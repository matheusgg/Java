package testes;

import sistema.Conta;

public class Teste extends Conta {

	public static void main(String[] args) {
		Conta c = new Conta();
		c.deposita(1000);
		System.out.println(c.getSaldo());
	}

}
