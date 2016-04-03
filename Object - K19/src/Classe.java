public class Classe {
	private int valor;

	public static void main(String[] args) {
		Classe c = new Classe();
		Classe c2 = new Classe();

		System.out.println(c.equals(c2));
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + valor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Classe))
			return false;
		Classe other = (Classe) obj;
		if (valor != other.valor)
			return false;
		return true;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
