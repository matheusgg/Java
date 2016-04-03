import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10000);
		Socket s = ss.accept();

		Scanner scan = new Scanner(s.getInputStream());

		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
			s.close();
			s = ss.accept();
		}
	}

}
