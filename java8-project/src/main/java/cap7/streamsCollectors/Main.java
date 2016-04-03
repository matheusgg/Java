package cap7.streamsCollectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import cap2.lambda.Usuario;

public class Main {

	public static void main(String[] args) {
		List<Usuario> usuarios = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			usuarios.add(new Usuario("Usuario " + i, (int) (Math.random() * 100) * (i + 1)));
		}

		/*
		 * Torna moderadores os 10 usu�rios com mais pontos
		 */
		usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());
		usuarios.subList(0, 10).forEach(Usuario::tornaModerador);
		usuarios.forEach(u -> System.out.println(u.getNome() + " / " + u.getPontos()));

		/*
		 * Os Streams s�o operacoes que podem ser realizadas sobre uma cole��o
		 * sem alter�-la. Ou seja, um Stream n�o altera a cole��o original!
		 */
		System.out.println("====================================================================");
		usuarios.stream().filter(u -> u.getPontos() > 5600).forEach(System.out::println);

		/*
		 * O m�todo collect possui uma sobrecarga que recebe 3 parametros de
		 * tipos de interfaces funcionais. O primeiro � um Supplier que ser�
		 * respons�vel por criar a lista que ser� retornada. O segundo � uma
		 * BiConsumer que ser� respons�vel por adicionar o item na lista
		 * retornada anteriormente. E, por fim, o terceiro � outro BiConsumer
		 * respons�vel por adicional itens na lista pararelamente.
		 */
		System.out.println("====================================================================");
		usuarios = usuarios.stream().filter(u -> u.getPontos() > 5600).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(usuarios);

		/*
		 * A segunda implementa��o do m�todo collect recebe um objeto do tipo
		 * Collector, respons�vel por realizar a coleta dos dados do Stream.
		 */
		usuarios = usuarios.stream().filter(u -> u.getPontos() > 5600).collect(Collectors.toList());
		System.out.println(usuarios);

		/*
		 * Map. Recuperando os pontos dos usuarios.
		 */
		System.out.println("====================================================================");
		List<Integer> pontos = usuarios.stream().mapToInt(Usuario::getPontos).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(pontos);

		/*
		 * Optional
		 */
		System.out.println("====================================================================");
		List<Integer> numeros = Arrays.asList(20, -56, 56, 98, 5, 78, 5, 1, 2, 5, 9, 85, 4, 8, 6, 95);
		int max = numeros.stream().mapToInt(n -> n).max().orElse(0);
		System.out.println(max);
	}
}
