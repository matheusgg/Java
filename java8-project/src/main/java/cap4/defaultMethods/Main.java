package cap4.defaultMethods;

import java.util.ArrayList;
import java.util.List;

import cap2.lambda.Usuario;

public class Main {

	public static void main(String[] args) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Usuario 1", 10));
		usuarios.add(new Usuario("Usuario 2", 20));
		usuarios.add(new Usuario("Usuario 3", 30));

		usuarios.removeIf(u -> u.getPontos() > 15);
		System.out.println(usuarios);
	}

}

/**
 * A partir do Java 8 foi introduzido o novo conceito "Default Methods", que tem
 * como objetivo adicionar funcionalidades em interfaces j� existentes mantendo
 * a compatibilidade, ou seja, m�todos default permitem que as interfaces
 * evoluam sem quebrar c�digos existentes.
 * 
 * @author mggoes
 *
 */
@FunctionalInterface
interface Teste1 {

	void compute();

	/**
	 * Um m�todo default n�o � considerado como um m�todo v�lido quando esta
	 * interface � funcional. Ou seja, interfaces funcionais s�o interfaces que
	 * possuem apenas um m�todo abstrato. M�todos default n�o s�o abstrados, por
	 * este motivo eles n�o s�o considerados. Um m�todos default podem ser
	 * sobrescrito e sempre s�o p�blicos.
	 * 
	 * @return
	 */
	default String generateMessage() {
		return "Message";
	}
}

interface InterA {

	default void show() {
		System.out.println("InterA.show()");
	}

}

interface InterB {

	default void show() {
		System.out.println("InterB.show()");
	}

}

/**
 * Pode ocorrer situa��es onde uma classe implemente v�rias interfaces e estas,
 * por sua vez, possuam m�todos com a mesma assinatura. Para resolver este
 * problema, � preciso implementar este m�todo duplicado para informar ao
 * compilador qual m�todo deve ser utilizado.
 * 
 * @author mggoes
 *
 */
class TestDuplicatedDefaultMethods implements InterA, InterB {

	@Override
	public void show() {
		InterA.super.show();// ou
		InterB.super.show();
	}

}
