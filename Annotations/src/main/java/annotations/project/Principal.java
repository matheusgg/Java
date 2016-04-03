package annotations.project;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import annotations.project.anotacoes.ShowMethod;
import annotations.project.util.Application;

public class Principal {
	public static void main(String[] args) {
		Application app = new Application();
		Principal.testaAnnotation(app);
	}

	/**
	 * Método que verifica se existe a anotação ShowMethod em algum método de
	 * uma determinada classe e imprime o nome do método de acordo com a
	 * quantidade de vezes que foi expecificado na annotation.
	 */
	public static void testaAnnotation(Object instancia) {
		Logger logger = Logger.getLogger(Principal.class);
		Class<? extends Object> classe = instancia.getClass();
		Method[] metodos = classe.getDeclaredMethods();
		for (Method m : metodos) {
			if (m.isAnnotationPresent(ShowMethod.class)) {
				ShowMethod anotacao = m.getAnnotation(ShowMethod.class);
				int qtd = anotacao.value();
				for (int i = 0; i < qtd; i++) {
					logger.info("O método " + m.getName() + " da classe " + classe.getSimpleName() + 
							" possui a anotação @ShowMethod. O valor informado foi " + anotacao.value());
				}
			}
		}
	}
}
