package br.estudos.enums;

/*
 * Enum com construtor;
 * 
 * Uma Enum pode possuir apenas construtores privados;
 * 
 * Dentro de um construtor de uma Enum, é obrigatório
 * inicializar todos os atributos finais;
 * 
 * Deve-se seguir uma ordem de declaração em uma Enum,
 * os tipos enumerados (P1, P2, ...) sempre devem ser 
 * declarados primeiro;
 * 
 * Se houver algum atributo static final, este deve ser
 * inicializado na sua declaração ou no inicializador
 * estático;
 * 
 * Enums pode ter atributos públicos simples;
 * 
 * Enums não podem ser instanciadas;
 * 
 * Enums podem possuir métodos;
 */
public enum Dados {
	P1("Matheus", 19), P2;

	/*
	 * Construtores
	 */
	private Dados(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	private Dados(String nome) {
		this.nome = nome;
		this.idade = 19;
	}

	private Dados() {
		this.nome = "Matheus";
		this.idade = 19;
	}

	/*
	 * Atributos
	 */
	private final String nome;
	private final int idade;

	private static final String profissao;
	private static final String hobbie = "Correr";

	public int ano;
	public static String pais;

	/*
	 * Inicializador estático
	 */
	static {
		profissao = "Estudante";
	}

	/*
	 * Getters e Setters
	 */
	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public static String getProfissao() {
		return profissao;
	}

	public static String getHobbie() {
		return hobbie;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public static String getPais() {
		return pais;
	}

	public static void setPais(String pais) {
		Dados.pais = pais;
	}

}
