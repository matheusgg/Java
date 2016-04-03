import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Conjuntos {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashSet<Integer> linked = new HashSet<Integer>();

		long tempo = Conjuntos.testaContains(list);
		System.out.println("Lista: " + tempo + "ms");

		tempo = Conjuntos.testaContains(linked);
		System.out.println("HashSet: " + tempo + "ms");
	}

	public static long testaContains(Collection<Integer> colecoes) {
		int size = 10000;

		for (int i = 0; i < size; i++) {
			colecoes.add(i);
		}

		long inicio = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			colecoes.contains(i);
		}
		long fim = System.currentTimeMillis();
		return fim - inicio;

	}

}
