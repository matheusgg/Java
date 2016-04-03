package app;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class App implements Teste {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// System.out.println("3/94.4-89.988-13/18".replaceAll("[\\.|\\-|\\/]",
		// ""));
		// System.out.println("11111111111".matches("^\\d{11}$"));
		// Runnable r = () -> System.out.println("Teste");
		// r.run();
		new App().metodo();
	}

	@Override
	@Anotacao
	public void metodo() throws NoSuchMethodException, SecurityException {
		this.getClass().getSuperclass().getDeclaredMethod("metodo").getAnnotationsByType(Anotacao.class);
	}

}

interface Teste {

	@Anotacao
	void metodo() throws NoSuchMethodException, SecurityException;

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@interface Anotacao {

}