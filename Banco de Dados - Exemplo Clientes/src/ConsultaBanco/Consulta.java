package ConsultaBanco;

import javax.swing.*;
import javax.swing.plaf.nimbus.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import ConectaBanco.*;

public class Consulta {
	private JFrame frame;
	private JTextArea ta;
	private JPanel panel;
	private JPanel panelText;	
	private JComboBox<String> combo;
	private ArrayList<RetornaConsulta> list;
	private String[] nomes;
	
	public Consulta(){
		combo = new JComboBox<String>(consultaBanco());
		combo.addActionListener(new MostraDados());
		ta = new JTextArea();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(combo);		
		panelText = new JPanel();
		panelText.add(ta);
		frame = new JFrame("Aplicativo de Consulta");
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, panelText);
		frame.setSize(300, 150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private String[] consultaBanco(){
		nomes = new String[3];
		ConectaBanco cb = new ConectaBanco();
		list = cb.executaQuery("select * from Clientes");
		
		for(int i = 0; i < list.size(); i++){
			nomes[i] = list.get(i).getNome();
		}
		
		return nomes;
	}

	public static void main(String[] args){	
		try{
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		}catch(UnsupportedLookAndFeelException ex){
			ex.printStackTrace();
		}
		new Consulta();
	}
	
	private class MostraDados implements ActionListener{
		public void actionPerformed(ActionEvent event){			
			int i = 0;
			while(true){
				if(combo.getSelectedItem().equals(nomes[i])){
					ta.setText("");
					ta.setText("Código: " + list.get(i).getCodigo() + "\nEndereço: " + list.get(i).getEndereco());
					break;
				}
				i++;
			}
		}
	}
}
	
