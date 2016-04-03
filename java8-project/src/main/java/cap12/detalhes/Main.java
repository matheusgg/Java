package cap12.detalhes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.security.PrivilegedAction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * No Java 8 é possível especificar a mesma anotação várias vezes sobre o mesmo
 * elemento.
 */
@Role("ADMIN")
@Role("ROOT")
public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		/*
		 * Ambiguidade de métodos no Java 8.
		 */
		new Main().metodo((Supplier<String>) () -> "teste");

		/*
		 * Cast de expressoes Lambda.
		 */
		System.out.println("===============================================");
		System.out.println(((Function<String, Integer>) Integer::parseInt).apply("10"));

		/*
		 * Melhoria na API de Reflection
		 */
		System.out.println("===============================================");
		Main main = new Main();
		Method metodo = main.getClass().getMethod("metodo", Supplier.class);
		Parameter[] parameters = metodo.getParameters();
		System.out.println(parameters[0].isNamePresent() + " / " + parameters[0].getName());
	}

	public void metodo(Supplier<String> s) {
		System.out.println("Main.metodo(Supplier)");
	}

	public void metodo(PrivilegedAction<String> p) {
		System.out.println("Main.metodo(PrivilegedAction)");
	}

}

/**
 * A anotação Repetable indica qual anotação armazenara as anotações do tipo
 * Role, deste modo, é possível especificar Role mais de uma vez sobre um mesmo
 * elemento. A anotação alvo de Repeatable deve possuir um atributo chamado
 * value do tipo da anotação que poderá ser repetida.
 * 
 * @author mggoes
 *
 */
@Repeatable(Roles.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Role {

	String value();

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Roles {

	Role[] value();

}
