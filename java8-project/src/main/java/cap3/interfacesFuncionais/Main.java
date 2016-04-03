package cap3.interfacesFuncionais;

public class Main {

	public static void main(String[] args) {
		/*
		 * No Java 8 s�o utilizadas t�cnicas de invokedynamic e method handlers
		 * para invocacao de expressoes lambdas.
		 */
		Teste teste = () -> System.out.println("Teste");
		System.out.println(teste);
		System.out.println(teste.getClass());

		/*
		 * � poss�vel acessar vari�veis locais de m�todos dentro de expressoes
		 * lambdas, assim como em classes anonimas. No java 8 a variavel local
		 * nao precisa ser necessariamente marcada como final, por�m ela precisa
		 * ser "efetivamente final", ou seja, ela nao pode ter o seu valor
		 * alterado. Esta regra vale tanto para expressoes lambdas como para
		 * classes anonimas.
		 */
		int numero = 10;
		Teste teste2 = () -> System.out.println(numero);
		teste2.show();
		// numero = 20; Erro de compilacao na expressao lambda
	}

}

/**
 * Para que uma expressao lambda possa ser utilizada, deve sempre existir uma
 * interface funcional envolvida no processo. Uma interface funcional � uma
 * interface que possui apenas um unico m�todo publico e abstrato. No java 8 foi
 * introduzia a anotacao "FunctionalInterface", que indica para o compilador que
 * esta interface � uma interface funcional, desta forma, no momento da
 * compilacao, caso o compilador identifique mais de um metodo publico e
 * abstrato nesta interface, um erro de compilacao sera gerado.
 * 
 * @author mggoes
 *
 */
@FunctionalInterface
interface Teste {

	void show();

}
