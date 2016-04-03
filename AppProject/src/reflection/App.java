package reflection;

public class App {

	public static void main(String... args) {
		new App().launch();
	}

	public void launch() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		System.out.println("launch... quem me chamou? " + stackTrace[2].getMethodName());
		this.teste1();
	}

	public void teste1() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		System.out.println("teste1... quem me chamou? " + stackTrace[2].getMethodName());
		this.teste2();
	}

	public void teste2() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		System.out.println("teste2... quem me chamou? " + stackTrace[2].getMethodName());
	}

}
