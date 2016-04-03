package metodosDefault;

public class NewBigClass implements NewBigInterface {

	@Override
	public void teste() {
		System.out.println("Teste subclasse");
	}

	/**
	 * É possível sobrescrever um método default, porém o modificador default
	 * nao deve ser informado.
	 */
	@Override
	public String getMsg() {
		return "Teste sobrescrita método default";
	}

}
