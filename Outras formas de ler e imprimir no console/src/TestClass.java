import java.io.*;

public class TestClass {

	public static void main(String[] args) {
		/************ LER ENTRADAS NO CONSOLE SEM A CLASSE SCANNER *************/
		byte[] scan = new byte[100]; // vetor de bytes que vai armazenar os endere�os de mem�ria
		System.out.println("Digite o seu nome:");
		
		try{
			System.in.read(scan);// Pode-se ler entrada do teclado desta forma, armazenando os dados em um vetor de bytes
			// Depois n�s passamos este vetor de bytes para um objeto String, a partir da�, podemos converter os conte�do para qualquer tipo primitivo			
			String s = new String(scan).trim();// O m�todo trim tira os espa�os em branco do in�cio e do fim de strings
			System.out.println(s);			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		/************ IMPRIMIR NO CONSOLE SEM O SYSTEM.OU.PRINT *************/		
		PrintStream ps = System.out; // O m�todo out da classe System retorna um PrintStrem, logo, podemos pass�-lo para um objeto PrintStream e imprimir qualquer mensagem a partir deste objeto
		ps.print("\n\nMatheus Gomes");	

	}

}
