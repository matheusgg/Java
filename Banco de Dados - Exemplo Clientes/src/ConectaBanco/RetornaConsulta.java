package ConectaBanco;

public class RetornaConsulta {
	private int cd_cliente;
	private String nome, endereco;
	
	public void setDados(int cd, String nom, String address){
		cd_cliente = cd;
		nome = nom;
		endereco = address;
	}
	
	public void setNome(String nom){
		nome = nom;
	}
	
	public int getCodigo(){
		return cd_cliente;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getEndereco(){
		return endereco;
	}


}
