public class Conta {
	private static int contador;
	private int numero;
	private double saldo;
	private double limite;

	public Conta() {
		Conta.contador++;
		this.numero = this.geraNumeroConta();
	}

	private int geraNumeroConta() {
		return Conta.contador;
	}

	public void deposita(double valor) {
		this.saldo += valor;
	}

	public void saca(double valor) {
		this.saldo -= valor;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

}
