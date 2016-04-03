package cap5.ordenacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import cap2.lambda.Usuario;

public class Main {

	public static void main(String[] args) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Usuario 2", 11));
		usuarios.add(new Usuario("Usuario 1", 2));
		usuarios.add(new Usuario("Usuario 3", 18));
		// usuarios.add(null);

		// usuarios.sort(Comparator.nullsFirst((u1, u2) ->
		// u1.getNome().compareTo(u2.getNome())));
		usuarios.sort(Comparator.comparing(Usuario::getNome));
		System.out.println(usuarios);

		// ===========================================================
		new Main().metodo();

		// ===========================================================
		List<String> palavras = Arrays.asList("Teste 3", "Teste 1", "Teste 4", "Teste 2");
		palavras.sort(Comparator.naturalOrder());
		System.out.println(palavras);

		// ===========================================================
		usuarios.sort(Comparator.comparingInt((Usuario u) -> u.getPontos()).reversed());
		System.out.println(usuarios);
	}

	/**
	 * A partir do Java 8 é possível especificar vários tipos para realização do
	 * cast explícito. Primeiro deve-se informar uma classe concreta, depois
	 * pode ser especificada uma ou mais interfaces.
	 * 
	 * @return
	 */
	public TesteCast metodo() {
		return (TesteCast & Serializable & Runnable) new TesteCast2();
	}
}

class TesteCast {

}

class TesteCast2 extends TesteCast implements Runnable, Serializable {

	private static final long serialVersionUID = 3393781211840653641L;

	@Override
	public void run() {

	}

}
