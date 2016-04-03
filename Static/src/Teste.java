public class Teste {
	public static void main(String[] args) {
		new Conta();
		new Conta();
		new Conta();

		Conta conta = new Conta();
		conta.saldo = 1000;
		conta.deposita(500);

		System.out.println(conta.saldo);
		System.out.println(Conta.contador);		
	}

}
