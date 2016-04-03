import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestaGet {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<Integer> linked = new LinkedList<Integer>();

		long tempo = TestaGet.get(list);
		System.out.println("Lista: " + tempo + "ms");

		tempo = TestaGet.get(linked);
		System.out.println("Linked: " + tempo + "ms");
	}

	public static long get(List<Integer> lista) {
		int size = 10000;

		for (int i = 0; i < size; i++) {
			lista.add(i);
		}

		long inicio = System.currentTimeMillis();

		for (int i = 0; i < size; i++) {
			lista.get(i);
		}

		long fim = System.currentTimeMillis();
		return fim - inicio;

	}
}
