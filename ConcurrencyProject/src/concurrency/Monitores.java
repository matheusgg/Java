package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitores {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		MyRun myRun = new MyRun(buffer);

		for (int i = 0; i < 3; i++) {
			new Thread(myRun, "Thread " + i).start();
		}
	}

}

class MyRun implements Runnable {

	private Buffer buffer;

	public MyRun(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		this.buffer.consume();
		this.buffer.consumeFree();
	}

}

class Buffer {
	private Lock lock = new ReentrantLock();
	private Condition fullCondition = this.lock.newCondition();
	private int count;

	public void consume() {
		try {
			this.lock.lock();
			System.out.println(Thread.currentThread().getName() + " obteve o lock!");

			this.count++;

			if (this.count == 2) {
				System.out.println("Buffer cheio! " + Thread.currentThread().getName() + " esperando...");
				this.fullCondition.await();
			}

			System.out.println(Thread.currentThread().getName() + " está utilizando o buffer!");
			Thread.sleep(5000);

			this.count--;

			this.lock.unlock();
			System.out.println(Thread.currentThread().getName() + " liberou o lock!");

			// this.fullCondition.signalAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void consumeFree() {
		System.out.println(Thread.currentThread().getName() + " chamou o método consumeFree!");
	}

}
