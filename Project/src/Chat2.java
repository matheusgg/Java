import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Chat2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 5100);
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		new Thread(new Chat2Server()).start();
		Scanner scan = new Scanner(System.in);
		String linha = scan.nextLine();
		while (!linha.equals("fim")) {
			pw.println(linha);
			pw.flush();
			linha = scan.nextLine();
		}

		scan.close();
		pw.close();
	}

	private static class Chat2Server implements Runnable {

		@Override
		public void run() {
			try {
				ServerSocket ss = new ServerSocket(5101);
				Socket s = ss.accept();

				BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String linha = "";
				while ((linha = reader.readLine()) != null) {
					System.out.println(linha);
				}

				reader.close();
				s.close();
				ss.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
