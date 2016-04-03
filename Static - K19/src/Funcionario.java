
public class Funcionario {
	static double valorValeRefeicao = 500;
	
	public void exibeValorValeRefeicao(){
		System.out.println("Valor: " + Funcionario.valorValeRefeicao);
	}
		
	public static void reajustaValorValeRefeicao(double valor){
		Funcionario.valorValeRefeicao += valor;
	}
	
}
