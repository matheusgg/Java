package colecoes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Colecoes {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(10, 64, 3, 29, 98, 20);
		// numeros.sort((o1, o2) -> o1.compareTo(o2)); // ou
		numeros.sort(Integer::compareTo);
		System.out.println(numeros);
		System.out.println(numeros.stream().filter((i) -> i > 50).collect(Collectors.toList()));
	}
}