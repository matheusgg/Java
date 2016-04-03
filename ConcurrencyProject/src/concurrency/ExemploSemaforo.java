package concurrency;

import java.util.concurrent.Semaphore;

public class ExemploSemaforo {

	public static void main(String[] args) {
		int numeroDePermissoes = 2;

		/*
		 * Apenas 2 threads podem acessar o método crítico ao mesmo tempo.
		 */
		Semaphore semaforo = new Semaphore(numeroDePermissoes);
		ClasseCritica classeCritica = new ClasseCritica();
		RunnableSemaforo runnableSemaforo = new RunnableSemaforo(classeCritica, semaforo);

		for (int i = 0; i < 10; i++) {
			new Thread(runnableSemaforo, "Thread " + i).start();
		}
	}
}

class RunnableSemaforo implements Runnable {

	private ClasseCritica classeCritica;
	private Semaphore semaforo;

	public RunnableSemaforo(ClasseCritica classeCritica, Semaphore semaforo) {
		this.classeCritica = classeCritica;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			this.classeCritica.metodoNaoCritico();

			this.semaforo.acquire(); // Adquire (ou tenta adiquirir) a permissao

			this.classeCritica.metodoCritico();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.semaforo.release(); // Libera a permissao
		}
	}

}

class ClasseCritica {
	private int count;

	public void metodoNaoCritico() {
		System.out.println("\tMétodo não crítico acessado pela Thread " + Thread.currentThread().getName());
	}

	public void metodoCritico() {
		System.out.println(this.count + "\tMétodo crítico acessado pela Thread " + Thread.currentThread().getName());

		if (++this.count == 2) {
			this.count = 0;
		}
	}
}