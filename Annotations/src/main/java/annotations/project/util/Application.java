package annotations.project.util;

import annotations.project.anotacoes.ShowMethod;

public class Application {

	/*
	 * Com esta annotation ser� impresso o nome do m�todo uma vez
	 */
	@ShowMethod(1)
	public void fazAlgo(String msg) {
		System.out.println(msg);
	}

	/*
	 * Com esta annotation ser� impresso o nome do m�todo tr�s vezes
	 */
	@ShowMethod(3)
	public String test() {
		return "";
	}

}
