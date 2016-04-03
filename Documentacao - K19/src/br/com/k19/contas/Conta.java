package br.com.k19.contas;

/**
 * <b> Documentacao da classe Conta </b>
 * 
 * @author Matheus
 * 
 */
public class Conta {

	/**
	 * Numero da conta <b>(Obs.: O valor nao pode ser negativo) </b>
	 */
	private int numero;

	/**
	 * Construtor da classe conta
	 * 
	 * @param numero
	 *            Numero que sera atribuido para a conta
	 * @throws IllegalArgumentException
	 *             Quando o valor informado e negativo
	 */
	public Conta(int numero) throws IllegalArgumentException {
		if (numero < 0) {
			throw new IllegalArgumentException("Número inválido");
		} else {
			this.numero = numero;
		}
	}

	/**
	 * Metodo get do numero da conta
	 * 
	 * @return O numero da conta
	 */
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
