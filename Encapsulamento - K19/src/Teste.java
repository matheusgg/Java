public class Teste {
	public static void main(String[] args) {
		Conta c1 = new Conta();
		c1.setLimite(500);
		c1.deposita(1500);
		c1.saca(300);
		System.out.println("Conta: " + c1.getNumero() + "\nSaldo: "
				+ c1.getSaldo());

		Conta c2 = new Conta();
		c2.setLimite(800);
		c2.deposita(1100);
		c2.saca(700);
		System.out.println("\n\nConta: " + c2.getNumero() + "\nSaldo: "
				+ c2.getSaldo());
	}
}