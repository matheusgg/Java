import java.io.*;

public class TestClass {

	public static void main(String[] args) {
		/************ LER ENTRADAS NO CONSOLE SEM A CLASSE SCANNER *************/
		byte[] scan = new byte[100]; // vetor de bytes que vai armazenar os endereços de memória
		System.out.println("Digite o seu nome:");
		
		try{
			System.in.read(scan);// Pode-se ler entrada do teclado desta forma, armazenando os dados em um vetor de bytes
			// Depois nós passamos este vetor de bytes para um objeto String, a partir daí, podemos converter os conteúdo para qualquer tipo primitivo			
			String s = new String(scan).trim();// O método trim tira os espaços em branco do início e do fim de strings
			System.out.println(s);			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		/************ IMPRIMIR NO CONSOLE SEM O SYSTEM.OU.PRINT *************/		
		PrintStream ps = System.out; // O método out da classe System retorna um PrintStrem, logo, podemos passá-lo para um objeto PrintStream e imprimir qualquer mensagem a partir deste objeto
		ps.print("\n\nMatheus Gomes");	

	}

}
