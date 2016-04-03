public class TestaHeranca {
	public void a(float f) {
		System.out.println("A");
	}

	public void a(double f) {
		System.out.println("B");
	}

	public void a2() {
		System.out.println("A");
	}

	public void b() {
		this.a2();
	}

	public static void main(String[] args) {
		new TestaHeranca().a(1); // Será impresso A
		new TestaHeranca2().b(); // Será impresso C
		// new TestaHeranca2().c(1, 1); Erro de compilação
	}
}
