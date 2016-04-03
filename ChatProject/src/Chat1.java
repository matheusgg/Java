import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Chat1 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		ServerSocket ss = new ServerSocket(5100);
		Socket s = ss.accept();
		new Thread(new Chat1Client()).start();

		BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String linha = "";
		while ((linha = reader.readLine()) != null) {
			System.out.println(linha);
		}

		reader.close();
		s.close();
		ss.close();

	}

	private static class Chat1Client implements Runnable {

		@Override
		public void run() {
			try {
				Socket s = new Socket("localhost", 5101);
				PrintWriter pw = new PrintWriter(s.getOutputStream());
				Scanner scan = new Scanner(System.in);
				String linha = scan.nextLine();
				while (!linha.equals("fim")) {
					pw.println(linha);
					pw.flush();
					linha = scan.nextLine();
				}

				scan.close();
				s.close();
				pw.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
