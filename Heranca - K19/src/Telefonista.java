public class Telefonista extends Funcionario {
	private int estacaoDeTrabalho;

	public Telefonista() {
		super("Telefonista");
	}

	@Override
	public void mostraDados() {
		super.mostraDados();
		System.out.println("Estação de trabalho: " + this.estacaoDeTrabalho);
	}

	public int getEstacaoDeTrabalho() {
		return estacaoDeTrabalho;
	}

	public void setEstacaoDeTrabalho(int estacaoDeTrabalho) {
		this.estacaoDeTrabalho = estacaoDeTrabalho;
	}
}
