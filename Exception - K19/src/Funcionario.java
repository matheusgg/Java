public class Funcionario {
	private double salario;

	public void aumentaSalario(double aumento) {
		if (aumento < 0) {
			throw new IllegalArgumentException(
					"Erro na execução da tarefa: O valor informado é menor que 0");
		} else {
			this.salario += aumento;
		}
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
