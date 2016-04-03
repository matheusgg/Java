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
 * como objetivo adicionar funcionalidades em interfaces já existentes mantendo
 * a compatibilidade, ou seja, métodos default permitem que as interfaces
 * evoluam sem quebrar códigos existentes.
 * 
 * @author mggoes
 *
 */
@FunctionalInterface
interface Teste1 {

	void compute();

	/**
	 * Um método default não é considerado como um método válido quando esta
	 * interface é funcional. Ou seja, interfaces funcionais são interfaces que
	 * possuem apenas um método abstrato. Métodos default não são abstrados, por
	 * este motivo eles não são considerados. Um métodos default podem ser
	 * sobrescrito e sempre são públicos.
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
 * Pode ocorrer situações onde uma classe implemente várias interfaces e estas,
 * por sua vez, possuam métodos com a mesma assinatura. Para resolver este
 * problema, é preciso implementar este método duplicado para informar ao
 * compilador qual método deve ser utilizado.
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
