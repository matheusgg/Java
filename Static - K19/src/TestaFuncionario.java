import java.io.IOException;
import java.net.UnknownHostException;


public class TestaFuncionario {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Funcionario f1 = new Funcionario();
		System.out.println("************* Funcionário 1 **********");
		f1.exibeValorValeRefeicao();
		
		Funcionario.reajustaValorValeRefeicao(300);
		
		Funcionario f2 = new Funcionario();
		System.out.println("************* Funcionário 2 **********");
		f2.exibeValorValeRefeicao();
	}

}
