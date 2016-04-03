package concurrency;

public class Threads {

	public static void main(String[] args) {

		Runnable runnable = new MyRunnable();

		for (int i = 0; i < 20; i++) {
			new Thread(runnable, "Thread " + i).start();
		}

		System.out.println("Thread main");
	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Executando a Thread " + Thread.currentThread().getName());
	}

}
