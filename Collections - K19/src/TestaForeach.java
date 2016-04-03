import java.util.LinkedList;
import java.util.List;

public class TestaForeach {
	public static void main(String[] args) {
		LinkedList<Integer> linked = new LinkedList<Integer>();

		int size = 10000;

		for (int i = 0; i < size; i++) {
			linked.add(i);
		}

		long tempo = TestaForeach.forTradicional(linked);
		System.out.println("For Tradicional: " + tempo + "ms");

		tempo = TestaForeach.foreach(linked);
		System.out.println("Foreach: " + tempo + "ms");
	}

	public static long forTradicional(List<Integer> lista) {
		long inicio = System.currentTimeMillis();

		for (int i = 0; i < lista.size(); i++) {
			lista.get(i);
		}

		long fim = System.currentTimeMillis();

		return fim - inicio;
	}

	public static long foreach(List<Integer> lista) {
		long inicio = System.currentTimeMillis();

		for (int x : lista) {

		}

		long fim = System.currentTimeMillis();

		return fim - inicio;
	}
}
