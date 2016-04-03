public class Gerente extends Funcionario {
	private String usuario;
	private String senha;

	public Gerente() {
		super("Gerente");
	}

	@Override
	public void mostraDados() {
		super.mostraDados();
		System.out.println("Usuário: " + this.usuario);
		System.out.println("Senha: " + this.senha);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
