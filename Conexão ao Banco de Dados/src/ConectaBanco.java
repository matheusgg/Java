/*****************************************************************************************************
 *****************************************************************************************************
 **Criando uma conexão ao SQL Server 2008 em Java utilizando o driver JDBC (Java DataBase Connector)**
 **Baixe o Driver JDBC adequado;																	**
 **Conforme a arquitetura do Windows, copie o arquivo “sqljdbc_auth.dll” para a pasta System32;		**
 **No Eclipse, importe a biblioteca “sqljdbc4.jar” para o seu projeto;								**
 *****************************************************************************************************
 ****************************************************************************************************/
import java.sql.*;// Importe esta pacote para utilizar as interfaces que lhe auxiliarão nas tarefas com o banco

public class ConectaBanco {

	public static void main(String[] args) {
		Connection con; // Crie um objeto de Conexão com o banco
		Statement stm; // Crie um objeto de Statement para executar as queries no banco
		String query = "select * from Clientes"; // Query simples
		
		try{// Aqui é feito o registro do driver, ou seja, é verificado se a classe existe no pacote, caso positivo, o inicializador estático registrará esta classe como um Driver imediatamente 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException ex){ex.printStackTrace();}
		
		try{
			// Aqui é obtida uma conexão com o banco através dos dados informados (Obs.: "integratedSecurity=true" significa utilizar a autenticação do windows)
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=DB_Teste; integratedSecurity=true");
			
			//Com a conexão estabelecida, o status é obtido
			stm = con.createStatement();
			
			// ResultSet é um objeto para receber resultados de queries, que neste caso, foi feita através do método de executar query do objeto stm
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

            //Fechamdno a instrução e a conexão
            stm.close();
            con.close();
		} catch(SQLException ex){
             System.err.println("SQLException: " + ex.getMessage());
        }
	}
}
