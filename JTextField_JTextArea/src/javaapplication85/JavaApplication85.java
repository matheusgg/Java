package javaapplication85;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaApplication85 {
    
    public static void main(String[] args) {
        /*JField_test field = new JField_test();
        field.go(); */
        
        JTextArea_test ta = new JTextArea_test();
        ta.go();
    }
}

/**************************** JTextFiel ***********************************/
class JField_test implements ActionListener{ 
    static JLabel label;
    static JTextField field;   
    
    public void go(){
        label = new JLabel("");
        JFrame frame = new JFrame("App");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        field = new JTextField("Matheus"); 
        field.addActionListener(this);
                
        panel.add(field);
        panel.add(label);
        
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 300);        
    }
    
    public void actionPerformed(ActionEvent event){
        label.setText(field.getText());        
    }
}

/**************************** JTextArea ***********************************/
/******************************** e ***************************************/
/*************************** JScrollPane **********************************/
class JTextArea_test{
    public void go(){   
        JFrame frame = new JFrame("App");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JTextArea text = new JTextArea(10,20); // 10 linhas e 20 colunas      
        text.setLineWrap(true); // Isso força a quebra de texto automaticamente
        text.setText("Texto de exemplo. ");
        text.append("Isso adiciona mais texto no final.");
        //text.selectAll();
        
        JScrollPane scroll = new JScrollPane(text); // Faz a área de texto ter barra de rolagem, isto é, cria a barra de rolagem e adiciona a área de texto
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Configura o scroll para ter somente scrool vertical
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
        
        panel.add(scroll);
        
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 300);  
    }
}