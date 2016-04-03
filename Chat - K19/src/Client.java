import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Scanner scan = new Scanner(System.in);
		Socket s = new Socket("192.168.1.136", 10000);
		PrintWriter w = new PrintWriter(s.getOutputStream());

		String linha = "";
		do {
			linha = scan.nextLine();
			w.println(linha);
			w.flush();
		} while (!linha.equals("fim"));

		s.close();
		w.close();
	}
}
