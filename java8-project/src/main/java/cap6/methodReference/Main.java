package cap6.methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) throws Exception {
		List<Teste> palavras = Arrays.asList(new Teste("Teste1"), new Teste("Teste2"), new Teste("Teste3"));
		palavras.forEach(Teste::printMsg);

		/*
		 * Referencia de método estático
		 */
		System.out.println("======================================================================");
		palavras.forEach(Teste::showMsg);

		System.out.println("======================================================================");
		Teste teste = new Teste("Mensagem");
		Consumer<Teste> consumer = Teste::printMsg;
		consumer.accept(teste);

		/*
		 * Referencia de método de instancia
		 */
		System.out.println("======================================================================");
		palavras.forEach(System.out::println);

		/*
		 * Referencia de construtor
		 */
		System.out.println("======================================================================");
		Supplier<Teste> testesFactory = Teste::new;
		Teste teste2 = testesFactory.get();
		System.out.println(teste2);

		/*
		 * Referencia de construtor com parametro
		 */
		System.out.println("======================================================================");
		Function<String, Teste> bigTestesFactory = Teste::new;
		Teste teste3 = bigTestesFactory.apply("Constructor reference with parameter");
		System.out.println(teste3);

		/*
		 * Referencia de construtor de um array
		 */
		System.out.println("======================================================================");
		Function<Integer, int[]> arrayFactory = int[]::new;
		int[] array = arrayFactory.apply(50);
		System.out.println(array.length);

		/*
		 * Super reference
		 */
		System.out.println("======================================================================");
		new Main().superReference();
	}

	public void superReference() throws Exception {
		Callable<String> callable = super::toString;
		System.out.println(callable.call());

		callable = this::toString;
		System.out.println(callable.call());

		callable = new String("Teste")::toString;
		System.out.println(callable.call());
	}

	@Override
	public String toString() {
		return "Main";
	}
}

class Teste {

	private String msg;

	public Teste() {

	}

	public Teste(String msg) {
		this.msg = msg;
	}

	public static void showMsg(Teste teste2) {
		System.out.println(teste2.msg);
	}

	public void printMsg() {
		System.out.println(this.msg);
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return this.msg;
	}
}
