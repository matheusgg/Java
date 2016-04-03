import javax.swing.*;
import javax.swing.plaf.nimbus.*;
import javax.swing.plaf.metal.*;
import java.awt.event.*;

public class LookAndFeelTest {
	JFrame frame;

	public static void main(String[] args) {
		new LookAndFeelTest().gui();	
	}
	
	public void gui(){
		/********************** Aqui a GUI é criada ***********************/
		JTextArea ta = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(ta);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton nimbusButton = new JButton("Nimbus");
		nimbusButton.addActionListener(new MudarParaNimbus());
		JButton metalButton = new JButton("Metal");
		metalButton.addActionListener(new MudarParaMetal());
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(nimbusButton);
		panel.add(metalButton);
		panel.add(scrollPane);		
		
		frame = new JFrame("LAF Teste");
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
	}
	
	/*************** Classe interna para mudar a skin para Nimbus *****************/
	private class MudarParaNimbus implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try{//O método setLookAndFeel lança exceções, por isso o bloco try... catch
				UIManager.setLookAndFeel(new NimbusLookAndFeel());//Seta o LookAndFeel para Nimbus, que é uma classe com os dados deste tema
				SwingUtilities.updateComponentTreeUI(frame);//Atualiza a árvore de componentes do frame para o tema ser exibido				
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
	
	/*************** Classe interna para mudar a skin para Metal *****************/
	private class MudarParaMetal implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try{//O método setLookAndFeel lança exceções, por isso o bloco try... catch
				UIManager.setLookAndFeel(new MetalLookAndFeel());//Seta o LookAndFeel para Metal, que é uma classe com os dados deste tema
				SwingUtilities.updateComponentTreeUI(frame);//Atualiza a árvore de componentes do frame para o tema ser exibido				
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
}
