package br.estudos.enums;

public class Principal {
	private Dados dado;

	public static void main(String[] args) {
		Dados.setPais("Brasil");
		System.out.println(Dados.getPais());
		System.out.println(Dados.getHobbie());
		System.out.println(Dados.getProfissao());
		/*
		 * 
		 */
		System.out.println("********************************************");
		Dados.P1.ano = 2012;
		System.out.println(Dados.P1.getAno());

		System.out.println(Dados.P1.getNome());
		System.out.println(Dados.P1.getIdade());
		/*
		 * 
		 */
		System.out.println("********************************************");
		Dados.P2.setAno(2000);
		System.out.println(Dados.P2.ano);

		/*
		 * 
		 */
		System.out.println("********************************************");
		String nome = Dados.P1.getNome();
		System.out.println(nome);
		/*
		 * 
		 */
		System.out.println("********************************************");
		for (Dados d : Dados.values()) {
			System.out.println(d);
		}
		/*
		 * 
		 */
		System.out.println("********************************************");
		new Principal().testaEnum();
	}

	public void testaEnum() {
		this.dado = Dados.P1;
		System.out.println(this.dado.getNome());
	}

	public Dados getDado() {
		return dado;
	}

	public void setDado(Dados dado) {
		this.dado = dado;
	}
}
