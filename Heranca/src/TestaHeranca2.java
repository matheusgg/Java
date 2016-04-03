public class TestaHeranca2 extends TestaHeranca {

	@Override
	public void a2() {
		System.out.println("C");
	}

	public void c(float f, double d) {
		System.out.println("C1");
	}

	public void c(double d, float f) {
		System.out.println("C2");
	}

}
