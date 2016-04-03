package br.clientes.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	private static Connection con;
	private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=Cad_Clientes;integratedSecurity=true";
	
	private static void registrarDriver(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver registrado!");
		}catch(ClassNotFoundException ex){
			System.err.println("Falha no registro do driver!");
			System.out.println(ex.getMessage());
			System.exit(1);
		}
	}
	
	public static void openConnection(){
		registrarDriver();
		try{
			con = DriverManager.getConnection(url);
			System.out.println("Conexão estabelecida!");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro na tentativa de conexão com a database! Tente novamente.", "Erro", 0);
			System.out.println(ex.getMessage());
			System.exit(0);
		}		
	}
	
	public static void closeConnection(){
		try{
			con.close();
		}catch(SQLException ex){
			System.err.println("Erro na tentativa de encerramento da conexão!");
		}		
	}
	
	public static Connection getCon() {			
		return con;
	}	
}
