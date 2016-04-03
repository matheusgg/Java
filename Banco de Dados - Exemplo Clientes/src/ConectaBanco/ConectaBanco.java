package ConectaBanco;
import java.sql.*;
import java.util.*;

public class ConectaBanco {
	private Connection con;
	private Statement stm;
	private ArrayList<RetornaConsulta> consulta = new ArrayList<RetornaConsulta>();
	
	private String registraDriver(){	
		boolean ver = false;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ver = true;
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
		
		if (ver) {
			return "Driver Registrado!";
		}else{
			return "Ocorreu um erro ao registrar o driver.\nTente Novamente.";
		}
	}
	
	private String conectaAoBanco(){
		boolean ver = false;
		try{
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=DB_Teste; integratedSecurity=true");
			stm = con.createStatement();
			ver = true;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		if (ver) {
			return "Conexão estabelecida!";
		}else{
			return "Ocorreu um erro ao conectar com o banco.\nTente Novamente.";
		}
	}
	
	public ArrayList<RetornaConsulta> executaQuery(String query){
		System.out.println(registraDriver());
		System.out.println(conectaAoBanco());
		
		try{
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {	
				RetornaConsulta rc = new RetornaConsulta();
				rc.setDados(rs.getInt("cd_cliente"), rs.getString("nm_cliente"), rs.getString("endereco"));
				consulta.add(rc);
			}
			
			con.close();
			stm.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}	
		
		return consulta;
	}
}
