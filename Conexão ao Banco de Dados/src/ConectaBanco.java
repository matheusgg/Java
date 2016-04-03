/*****************************************************************************************************
 *****************************************************************************************************
 **Criando uma conex�o ao SQL Server 2008 em Java utilizando o driver JDBC (Java DataBase Connector)**
 **Baixe o Driver JDBC adequado;																	**
 **Conforme a arquitetura do Windows, copie o arquivo �sqljdbc_auth.dll� para a pasta System32;		**
 **No Eclipse, importe a biblioteca �sqljdbc4.jar� para o seu projeto;								**
 *****************************************************************************************************
 ****************************************************************************************************/
import java.sql.*;// Importe esta pacote para utilizar as interfaces que lhe auxiliar�o nas tarefas com o banco

public class ConectaBanco {

	public static void main(String[] args) {
		Connection con; // Crie um objeto de Conex�o com o banco
		Statement stm; // Crie um objeto de Statement para executar as queries no banco
		String query = "select * from Clientes"; // Query simples
		
		try{// Aqui � feito o registro do driver, ou seja, � verificado se a classe existe no pacote, caso positivo, o inicializador est�tico registrar� esta classe como um Driver imediatamente 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException ex){ex.printStackTrace();}
		
		try{
			// Aqui � obtida uma conex�o com o banco atrav�s dos dados informados (Obs.: "integratedSecurity=true" significa utilizar a autentica��o do windows)
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=DB_Teste; integratedSecurity=true");
			
			//Com a conex�o estabelecida, o status � obtido
			stm = con.createStatement();
			
			// ResultSet � um objeto para receber resultados de queries, que neste caso, foi feita atrav�s do m�todo de executar query do objeto stm
			ResultSet rs = stm.executeQuery(query);			 

            System.out.println("Lista de linhas da tabela Clientes:");

            // Fazendo um loop para mostrar tudo o que foi retornado do banco
            while (rs.next()){
            	
            	// Obtendo o campo name em um string
            	String s = rs.getString("nome");
            
            	// Obtendo o campo cd em um inteiro
            	int i = rs.getInt("cd_cliente");
            
            	System.out.println(i + " " + s);
            }

            //Fechamdno a instru��o e a conex�o
            stm.close();
            con.close();
		} catch(SQLException ex){
             System.err.println("SQLException: " + ex.getMessage());
        }
	}
}
