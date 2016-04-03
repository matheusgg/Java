package receiver;

public class Receiver {

	public void teste(Receiver this, String teste) {
		System.out.println(teste);
	}

	public static void main(String[] args) {
		new Receiver().teste("Valor");
	}

}
