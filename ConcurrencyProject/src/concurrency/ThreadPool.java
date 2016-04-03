package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	public static void main(String[] args) throws Exception {
		MyTask myTask = new MyTask();
		List<Callable<String>> tasks = new ArrayList<>();
		tasks.add(myTask);
		tasks.add(myTask);

		// Lista de receberá os resultados das tasks. Cada Future representa um
		// resultado.
		List<Future<String>> futures = new ArrayList<>();

		/*
		 * SINGLE THREAD EXECUTOR - Cria apenas uma thread para execução das
		 * tarefas
		 */
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		futures.addAll(singleThreadExecutor.invokeAll(tasks));
		for (Future<String> fut : futures) {
			System.out.println(fut.get());
		}
		singleThreadExecutor.shutdown();

		/*
		 * CACHED THREAD POOL - Cria quantas threads forem necessárias para
		 * executar as tarefas. Caso algumas dessas threads fique mais de 60
		 * segundos sem ser utilizada, ele é removida do pool.
		 */
		System.out.println("==============================");
		futures.clear();
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		futures.addAll(cachedThreadPool.invokeAll(tasks));
		for (Future<String> fut : futures) {
			System.out.println(fut.get());
		}
		cachedThreadPool.shutdown();

		/*
		 * FIXED THREAD POOL - Cria a quantidade de threads informada para
		 * execucao das tarefas. Caso alguma thread nao esteja disponível, a
		 * tarefa é colocada em uma fila para execucao.
		 */
		System.out.println("==============================");
		futures.clear();
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
		futures.addAll(fixedThreadPool.invokeAll(tasks));
		for (Future<String> fut : futures) {
			System.out.println(fut.get());
		}
		fixedThreadPool.shutdown();

		/*
		 * SCHEDULED THREAD POOL - Cria quantas threads forem especificadas e
		 * executa uma tarefa em um determinado momento agentado.
		 */
		System.out.println("==============================");
		futures.clear();
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
		futures.addAll(scheduledThreadPool.invokeAll(tasks));
		for (Future<String> fut : futures) {
			System.out.println(fut.get());
		}
		ScheduledFuture<?> scheduledFuture = scheduledThreadPool.schedule(new BigRunnable(), 5, TimeUnit.SECONDS);
		System.out.println(scheduledFuture.get());
		scheduledThreadPool.shutdown();

		/*
		 * SINGLE THREAD SCHEDULED EXECUTOR - Utiliza uma thread para executar
		 * as tarefas. Utiliza essa mesma thread para executar as tarefas
		 * agendadas.
		 */
		System.out.println("==============================");
		futures.clear();
		ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
		futures.addAll(singleThreadScheduledExecutor.invokeAll(tasks));
		for (Future<String> fut : futures) {
			System.out.println(fut.get());
		}
		ScheduledFuture<?> sFuture = singleThreadScheduledExecutor.schedule(new BigRunnable(), 10, TimeUnit.SECONDS);
		System.out.println(sFuture.get());
		singleThreadScheduledExecutor.shutdown();
	}
}

class BigRunnable implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " está executando...");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class MyTask implements Callable<String> {
	private int count;

	@Override
	public String call() throws Exception {
		return String.valueOf(this.count++) + " - " + Thread.currentThread().getName();
	}

}
