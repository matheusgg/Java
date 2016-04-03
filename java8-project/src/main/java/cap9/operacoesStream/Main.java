package cap9.operacoesStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import cap2.lambda.Usuario;

public class Main {

	public static void main(String[] args) throws IOException {
		/*
		 * Gerando um mapa com o path e todas as linhas do arquivo representado
		 * por este path. O método estático "identity" de Function retorna uma
		 * expressão lambda que apenas recebe e devolve o mesmo parâmetro.
		 */
		Map<Path, List<String>> files = Files.list(Paths.get("./src/main/java/cap2/lambda")).collect(
				Collectors.toMap(Function.identity(), p -> Main.lines(p).collect(Collectors.toList())));
		System.out.println(files);

		/*
		 * Adicionando usuarios no mapa caso nao exista a pontuação.
		 */
		System.out.println("===============================================================================");
		List<Usuario> usuarios = Arrays.asList(new Usuario("Usuario 1", 150, true), new Usuario("Usuario 2", 90, true), new Usuario("Usuario 3", 170),
				new Usuario("Usuario 4", 90));

		Map<Integer, List<Usuario>> mapUsers = new HashMap<>();
		for (Usuario usuario : usuarios) {
			mapUsers.computeIfAbsent(usuario.getPontos(), user -> new ArrayList<>()).add(usuario);
		}

		System.out.println(mapUsers);

		/*
		 * Agrupando os usuarios por pontos.
		 */
		System.out.println("===============================================================================");
		Map<Integer, List<Usuario>> usuariosAgrupados = usuarios.stream().collect(Collectors.groupingBy(Usuario::getPontos));
		System.out.println(usuariosAgrupados);

		/*
		 * Recuperando apenas os nomes dos usuarios normais e moderadores.
		 */
		System.out.println("===============================================================================");
		Map<Boolean, List<String>> nomesModeradores = usuarios.stream().collect(
				Collectors.partitioningBy(Usuario::isModerador, Collectors.mapping(Usuario::getNome, Collectors.toList())));
		System.out.println(nomesModeradores);

		/*
		 * Recuperando a soma dos pontos dos usuarios normais e moderadores.
		 */
		System.out.println("===============================================================================");
		Map<Boolean, Integer> somaPontos = usuarios.stream()
				.collect(Collectors.partitioningBy(Usuario::isModerador, Collectors.summingInt(Usuario::getPontos)));
		System.out.println(somaPontos);

		/*
		 * Concatenando os nomes de todos os usuarios.
		 */
		System.out.println("===============================================================================");
		String nomes = usuarios.stream().map(Usuario::getNome).collect(Collectors.joining(", "));
		System.out.println(nomes);

		/*
		 * Stream paralelo.
		 */
		System.out.println("===============================================================================");
		long soma = LongStream.range(0, 1_000_000_000).parallel().filter(x -> x % 2 == 0).sum();
		System.out.println(soma);
	}

	private static Stream<String> lines(Path p) {
		try {
			return Files.lines(p, StandardCharsets.ISO_8859_1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
