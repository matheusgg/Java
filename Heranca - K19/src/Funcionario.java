public class Funcionario {
	private String nome;
	private double salario;
	private String cargo;

	public Funcionario(String cargo) {
		this.cargo = cargo;
	}

	public double calculaBonificacao() {
		return this.salario * 0.6;
	}

	public void mostraDados() {
		System.out.println("\n\n***** Dados do " + this.cargo + " *****");
		System.out.println("Nome: " + this.nome);
		System.out.println("Salário R$: " + this.salario);
		System.out.println("Bonificação R$: " + this.calculaBonificacao());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
