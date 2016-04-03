package metodosDefault;

public class MetodosDefault {

	public static void main(String[] args) {
		NewBigInterface nbi = () -> System.out.println("Teste");
		nbi.teste();
		System.out.println(nbi.getMsg());
		System.out.println(NewBigInterface.getSaudacao());
		// System.out.println(nbi.getSaudacao()); // Erro de compilacao

		/*
		 * Subclasse de NewBigInterface
		 */
		NewBigClass nbc = new NewBigClass();
		nbc.teste();
		System.out.println(nbc.getMsg());
	}

}