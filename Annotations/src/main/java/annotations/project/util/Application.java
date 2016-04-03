package annotations.project.util;

import annotations.project.anotacoes.ShowMethod;

public class Application {

	/*
	 * Com esta annotation será impresso o nome do método uma vez
	 */
	@ShowMethod(1)
	public void fazAlgo(String msg) {
		System.out.println(msg);
	}

	/*
	 * Com esta annotation será impresso o nome do método três vezes
	 */
	@ShowMethod(3)
	public String test() {
		return "";
	}

}
