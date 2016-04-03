package anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * TYPE_PARAMETER indica que essa anotacao é aplicavel na declaracao de tipos
 * parametrozados.
 * 
 * @author Matheus
 *
 */
@Target(ElementType.TYPE_PARAMETER)
@interface TypeAnnotation {

}

/**
 * TYPE_USE indica que esta anotacao é aplicavel em qualquer lugar que utiliza
 * um tipo generico.
 * 
 * @author Matheus
 *
 */
@Target(ElementType.TYPE_USE)
@interface TypeUseAnnotation {

}

/**
 * No java 8 é possível utilizar anotacoes em vários locais.
 * 
 * @author Matheus
 *
 */
public class Anotacoes extends @TypeUseAnnotation Object implements @TypeUseAnnotation Runnable {

	public static void main(String[] args) {
		List<@TypeUseAnnotation String> lista = new ArrayList<@TypeUseAnnotation String>();
		System.out.println(lista);

		/*
		 * O objeto informado ara este método deve implementar todas as
		 * interfaces declaradas no tipo generico.
		 */
		// Anotacoes.metodoComGeneric(new Teste()); // Erro de compilacao
		Anotacoes.metodoComGeneric(new Classe2());
	}

	/**
	 * É possível especificar vários tipos depois de extends, porém a classe
	 * deve ser o primeiro tipo especificado. Os demais tipos devem ser
	 * interfaces.
	 * 
	 * @param t
	 */
	public static <@TypeUseAnnotation T extends Classe3 & Runnable & Cloneable> void metodoComGeneric(T t) {
		System.out.println(t);
	}

	public static @TypeUseAnnotation String metodoComRetorno() throws @TypeUseAnnotation RuntimeException, @TypeUseAnnotation IllegalArgumentException {
		return "Teste de anotacao no retorno e na declaracao de excecao";
	}

	@Override
	public void run() {
		System.out.println("Teste run");
	}
}

class AnotacoesTeste<@TypeUseAnnotation T, @TypeAnnotation V> {

}

class Classe1 implements Runnable {

	@Override
	public void run() {
		System.out.println("Teste");
	}

}

class Classe2 extends Classe3 implements Runnable, Cloneable {

	@Override
	public void run() {
		System.out.println("Teste2");
	}

}

class Classe3 {

}
