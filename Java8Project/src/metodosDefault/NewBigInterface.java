package metodosDefault;

/**
 * As interface no Java 8 ganharam novas funcionalidades. Agora é possível criar
 * métodos default e estáticos. Esses métodos devem ser públicos e conseguem
 * acessar as constantes declaradas na interface.
 * 
 * @author Matheus
 *
 */
public interface NewBigInterface {

	String NOME = "Matheus";

	void teste();

	/**
	 * Métodos default são métodos que proveem uma implementacao padrao e nao
	 * precisam ser implementados pelas subclasses. O modificador default é
	 * permitido somente dentro de interfaces.
	 * 
	 * @return
	 */
	default String getMsg() {
		return "Olá " + NewBigInterface.NOME;
	}

	/**
	 * Agora é possível declarar métodos estáticos dentro de interfaces. Porém
	 * existe uma restricao, não é possivel chamar este metodo atraves de uma
	 * variavel de referencia, apenas com NewBigInterface.getSaudacao();
	 * 
	 * @return
	 */
	static String getSaudacao() {
		return "Olá denovo " + NewBigInterface.NOME;
	}

}
