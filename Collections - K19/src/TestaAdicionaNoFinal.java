import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestaAdicionaNoFinal {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<Integer> linked = new LinkedList<Integer>();

		long tempo = TestaAdicionaNoFinal.adicionaNoFinal(list);
		System.out.println("Lista: " + tempo + "ms");

		tempo = TestaAdicionaNoFinal.adicionaNoFinal(linked);
		System.out.println("Linked: " + tempo + "ms");
	}

	public static long adicionaNoFinal(List<Integer> lista) {
		long inicio = System.currentTimeMillis();
		int size = 10000;

		for (int i = 0; i < size; i++) {
			lista.add(i);
		}
		long fim = System.currentTimeMillis();
		return fim - inicio;

	}

}
