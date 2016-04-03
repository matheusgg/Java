package cap2.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		Usuario u1 = new Usuario("Usuario 1", 150);
		Usuario u2 = new Usuario("Usuario 2", 120);
		Usuario u3 = new Usuario("Usuario 3", 190);

		List<Usuario> usuarios = Arrays.asList(u1, u2, u3);

		// Maneira antiga
		usuarios.forEach(new Consumer<Usuario>() {
			public void accept(Usuario u) {
				System.out.println(u.getNome());
			}
		});

		// Lambdas
		/*
		 * Não é permitido declarar parametros de expressoes lambdas com o mesmo
		 * nome de parametros do contexto de invocação da expressao.
		 */
		// Usuario usuario = null;
		usuarios.forEach(usuario -> System.out.println(usuario.getNome()));
	}
}
