package br.clientes.view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import br.clientes.controller.ClienteDAO;
import br.clientes.controller.Conexao;


public class Laucher {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException ex) {
			System.out.println("Tema não Suportado!");
		}
		Conexao.openConnection();	
		new ClienteDAO().consultaBanco();
		new CRUD().setVisible(true);	
	}
}
