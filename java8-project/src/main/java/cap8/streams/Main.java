package cap8.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import cap2.lambda.Usuario;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Usuario> usuarios = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			usuarios.add(new Usuario("Usuario " + i, (int) (Math.random() * 100) * (i + 1)));
		}

		/*
		 * As operações dentro dos Streams são Lazy, ou seja, elas só são
		 * executadas quando uma operação terminal é invocada.
		 */
		usuarios.stream().filter(u -> u.getPontos() > 3600).sorted(Comparator.comparing(Usuario::getNome)).forEach(System.out::println);

		/*
		 * O método peek é uma operação intermediária executada toda vez que um
		 * elemento do Stream é consumido em uma operação terminal.
		 */
		System.out.println("==============================================================================================================");
		usuarios.stream().filter(u -> u.getPontos() > 3600).peek(System.out::println).findFirst();

		/*
		 * Operações de redução
		 */
		System.out.println("==============================================================================================================");
		int sum1 = usuarios.stream().filter(u -> u.getPontos() > 3600).mapToInt(u -> u.getPontos()).sum();
		System.out.println(sum1);

		/*
		 * Soma manual
		 */
		OptionalInt sum2 = usuarios.stream().filter(u -> u.getPontos() > 3600).mapToInt(u -> u.getPontos()).reduce(Integer::sum);
		// OptionalInt sum2 = usuarios.stream().filter(u -> u.getPontos() >
		// 3600).mapToInt(u -> u.getPontos()).reduce((i1, i2) -> i1 + i2);
		System.out.println(sum2.orElse(0));

		/*
		 * Multipliacacao
		 */
		IntStream stream = usuarios.stream().filter(u -> u.getPontos() > 3600).mapToInt(u -> u.getPontos()).peek(System.out::println);
		int mult = stream.reduce(1, (i1, i2) -> i1 * i2);
		System.out.println(mult);

		/*
		 * Esta linha lancara uma excecao, pois este Stream já foi utilizado, ou
		 * seja, uma operação final ja foi invocada nele e o mesmo esta fechado.
		 */
		// stream.forEach(System.out::println);

		System.out.println("==============================================================================================================");
		boolean hasModerador = usuarios.stream().noneMatch(Usuario::isModerador);
		System.out.println(hasModerador);

		/*
		 * Gerando 6 numeros aleatorios
		 */
		System.out.println("==============================================================================================================");
		System.out.println(new Random().ints(0, 61).limit(6).sorted().boxed().collect(Collectors.toList()));

		/*
		 * FlatMap é uma operação que desembrulha um Stream dentro de outro
		 * (Stream<Stream<?>>), resultando em um Stream desemcapsulado
		 * (Stream<?>).
		 */
		System.out.println("==============================================================================================================");
		Stream<String> lines = Files.list(Paths.get("./src/main/java/cap2/lambda")).filter(p -> p.toString().endsWith(".java")).flatMap(p -> Main.lines(p));
		lines.forEach(System.out::println);

		/*
		 * Transformando um Stream de grupos de usuarios em um Stream de
		 * usuarios com o FlatMap
		 */
		System.out.println("==============================================================================================================");
		Grupo grupo1 = new Grupo();
		Grupo grupo2 = new Grupo();
		List<Grupo> grupos = Arrays.asList(grupo1, grupo2);

		Stream<String> usrs = grupos.stream().flatMap(g -> g.getUsuarios().stream());
		System.out.println(usrs.count());
	}

	private static Stream<String> lines(Path p) {
		try {
			return Files.lines(p, StandardCharsets.ISO_8859_1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class Grupo {

	private Set<String> usuarios = new HashSet<String>();

	/**
	 * @return the usuarios
	 */
	public Set<String> getUsuarios() {
		return usuarios;
	}

}
