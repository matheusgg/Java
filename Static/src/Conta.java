public class Conta {
	static int contador;
	double saldo;

	public Conta() {
		Conta.contador++;
	}

	public void deposita(double valor) {
		this.saldo += valor;
	}
}
