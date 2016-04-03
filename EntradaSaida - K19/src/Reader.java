import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Reader {
	public static void main(String[] args) throws FileNotFoundException {
		new Reader().readEntry();

	}

	public void readEntry() throws FileNotFoundException {
		File arquivoSaida = new File("saida.txt");

		Scanner scan = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(arquivoSaida);

		System.out.println("Digite um texto:");

		String linha = "";

		do {
			linha = scan.nextLine();
			writer.println(linha);
		} while (!linha.equals("fim"));

		writer.close();
		scan.close();
		System.out.println("Concluído!");
	}

	public void copy() throws FileNotFoundException {
		File arquivoSaida = new File("saida.txt");
		File arquivo = new File("entrada.txt");

		Scanner scan = new Scanner(arquivo);
		PrintWriter writer = new PrintWriter(arquivoSaida);

		while (scan.hasNextLine()) {
			writer.println(scan.nextLine());
		}

		writer.close();
		scan.close();
		System.out.println("Concluído!");

	}
}
