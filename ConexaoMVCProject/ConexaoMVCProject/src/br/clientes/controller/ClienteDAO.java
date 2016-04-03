package br.clientes.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.clientes.model.Cliente;
import br.clientes.view.CRUD;


public class ClienteDAO {
	private PreparedStatement pst;
	private ResultSet rs;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private final String selectQuery = "SELECT * FROM clientes";
	private final String insertQuery = "INSERT INTO clientes values(?,?,?,?)";
	private final String deleteQuery = "DELETE FROM clientes where cpf=?";
	private final String updateQuery = "UPDATE clientes SET nome=?,telefone=?,endereco=? WHERE cpf=?";
	
	public ArrayList<Cliente> consultaBanco() {
		try {
			pst = Conexao.getCon().prepareStatement(selectQuery);
			rs = pst.executeQuery();
			while (rs.next()) {
				clientes.add(new Cliente(rs.getString("nome"), rs
						.getString("endereco"), rs.getString("telefone"), rs
						.getString("cpf")));
			}
			pst.close();
			CRUD.atualizaGrid(clientes);
		} catch (SQLException ex) {
			JOptionPane
					.showMessageDialog(
							null,
							"N�o foi poss�vel obter a conex�o com o banco\nou n�o foram encontradas ocorr�ncias na base de dados",
							"Erro", 0);
			System.err.println(ex.getMessage());
		}
		return clientes;
	}

	public boolean verificaDadosCliente(String nome, String endereco,
			String telefone, String cpf) {
		if (!nome.equals("") && !endereco.equals("") && !telefone.equals("")
				&& (!cpf.equals(""))) {
			return true;
		} else {
			return false;
		}
	}

	public void cadastro(Cliente cli) {
		try {
			pst = Conexao.getCon().prepareStatement(insertQuery);
			pst.setString(1, cli.getNome());
			pst.setString(2, cli.getTelefone());
			pst.setString(3, cli.getEndereco());
			pst.setString(4, cli.getCpf());
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null,
					"Cadastro efetuado com sucesso!", "Cadastro", 1);
			consultaBanco();
		} catch (SQLException ex) {
			if (ex.getMessage().contains("'PK__clientes__D836E71E03317E3D'")) {
				JOptionPane.showMessageDialog(null, "Cliente j� cadastrado!",
						"Erro", 0);
			} else {
				JOptionPane
						.showMessageDialog(
								null,
								"Ocorreu um erro durante o cadastro do cliente.\nPor favor, tente novamente.",
								"Erro", 0);
				System.err.println(ex.getMessage());
			}
		}
	}
	
	public void exclusao(Cliente cli) {
		try{
			pst = Conexao.getCon().prepareStatement(deleteQuery);
			pst.setString(1, cli.getCpf());
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null,
					"Exclus�o efetuada com sucesso!", "Exclus�o", 1);
			consultaBanco();			
		}catch(SQLException ex){
			JOptionPane
			.showMessageDialog(
					null,
					"Ocorreu um erro durante a exclus�o do cliente.\nPor favor, tente novamente.",
					"Erro", 0);
			System.err.println(ex.getMessage());
		}
	}
	
	public void alteracao(Cliente cli) {
		try{
			pst = Conexao.getCon().prepareStatement(updateQuery);
			pst.setString(1, cli.getNome());
			pst.setString(2, cli.getTelefone());
			pst.setString(3, cli.getEndereco());
			pst.setString(4, cli.getCpf());
			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null,
					"Altera��o efetuada com sucesso!", "Altera��o", 1);
			consultaBanco();			
		}catch(SQLException ex){
			JOptionPane
			.showMessageDialog(
					null,
					"Ocorreu um erro durante a altera��o do cliente.\nPor favor, tente novamente.",
					"Erro", 0);
			System.err.println(ex.getMessage());
		}
	}
}
