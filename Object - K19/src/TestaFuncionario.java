
public class TestaFuncionario {
	public static void main(String[] args) {
		Funcionario f = new Funcionario();
		f.setNome("Matheus");
		f.setSalario(1000);

		Funcionario f2 = new Funcionario();
		f2.setNome("Matheus");
		f2.setSalario(1000);

		System.out.println(f.equals(f2));
		System.out.println(f.hashCode());
		System.out.println(f2.hashCode());

		// String codigo = Integer.toHexString(f.hashCode());
		// System.out.println(f.getClass().getName().concat("@").concat(codigo));
	}
}
