public class TestaFuncionario {
	public static void main(String[] args) {
		try {
			new Funcionario().aumentaSalario(-500);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
