package cap2.lambda;

public class Usuario {

	private String nome;
	private int pontos;
	private boolean moderador;

	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {

	}

	/**
	 * @param nome
	 * @param pontos
	 */
	public Usuario(String nome, int pontos) {
		this.nome = nome;
		this.pontos = pontos;
	}

	/**
	 * Instantiates a new usuario.
	 *
	 * @param nome
	 *            the nome
	 * @param pontos
	 *            the pontos
	 * @param moderador
	 *            the moderador
	 */
	public Usuario(String nome, int pontos, boolean moderador) {
		this.nome = nome;
		this.pontos = pontos;
		this.moderador = moderador;
	}

	/**
	 * Torna moderador.
	 */
	public void tornaModerador() {
		this.moderador = true;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the pontos
	 */
	public int getPontos() {
		return pontos;
	}

	/**
	 * @param pontos
	 *            the pontos to set
	 */
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	/**
	 * @return the moderador
	 */
	public boolean isModerador() {
		return moderador;
	}

	/**
	 * @param moderador
	 *            the moderador to set
	 */
	public void setModerador(boolean moderador) {
		this.moderador = moderador;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.nome;
	}

}
