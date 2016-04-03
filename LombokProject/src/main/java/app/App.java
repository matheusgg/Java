package app;

import java.io.IOException;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.Synchronized;
import lombok.extern.java.Log;

/**
 * Lombok é uma biblioteca e um plugin que se integra a IDE, provendo um
 * conjunto de anotações para geracão de código que é utilizado em tempo de
 * desenvolvimento.
 * 
 * @author Matheus
 *
 */
@Log
public class App {

	@Getter(lazy = true)
	private final int valor = this.calculaValor();

	public static void main(String[] args) {
		// Log - Existem 6 tipos de logs CommonsLog, Log, Log4j, Log4j2, Slf4j e
		// XSlf4j
		App.log.info("Log de info");

		// ToString
		// Cliente cliente = new Cliente();
		// cliente.setId(10l);
		// System.out.println(cliente);
		//
		// Cliente cliente2 = new Cliente();
		// cliente2.setId(20l);
		// System.out.println(cliente2);

		// Equals
		// System.out.println(cliente.equals(cliente2));

		// Fechamento de recurso automatico (try... finally)
		// try {
		//
		// @Cleanup("fecha")
		// IOBigClass io = new IOBigClass();
		// System.out.println(io);
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// Synchronized
		// new App().metodoSincronizado();

		// SneakyThrow
		// new App().metodoDeExcecao();

		// Getter
		// App app = new App();
		// System.out.println(app.getValor());
		// System.out.println(app.getValor());

		// val
		// val valor1 = new Integer(10);
		// System.out.println(valor1.longValue());
		//
		// val valor2 = new ArrayList<String>();
		// System.out.println(valor2.size());
	}

	@Synchronized
	public void metodoSincronizado() {
		System.out.println("Teste");
	}

	@SneakyThrows
	public void metodoDeExcecao() {
		throw new IOException("Excecao de IO");
	}

	public int calculaValor() {
		System.out.println("calculando...");
		return (int) (Math.random() * 1000);
	}

}

class IOBigClass {

	public void fecha() throws IOException {
		throw new IOException("Teste");
	}
}
