public class Secretaria extends Funcionario {
	private int ramal;

	public Secretaria() {
		super("Secretária");
	}

	@Override
	public void mostraDados() {
		super.mostraDados();
		System.out.println("Ramal: " + this.ramal);
	}

	public int getRamal() {
		return ramal;
	}

	public void setRamal(int ramal) {
		this.ramal = ramal;
	}
}
