package javaapplication77;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaApplication77 {
    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        JavaApplication77 gui = new JavaApplication77();
        gui.go();
    }
    
    public void go(){
        frame = new JFrame("Two Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton labelbutton = new JButton("Change Label");
        //JavaApplication77 teste = new JavaApplication77();
        //JavaApplication77.LabelListener teste2 = teste.new LabelListener(); // Sintaxe para instanciar uma classe interna        
        // labelbutton.addActionListener(teste2); <=== Isto é a mesma coisa disto:
        labelbutton.addActionListener(new LabelListener()); // <===
        
        JButton colorbutton = new JButton("Change Circle");
        colorbutton.addActionListener(new ColorListener());
        
        label  = new JLabel("I'm a Label");
        MyDrawPanel drawPanel = new MyDrawPanel();
        
        frame.getContentPane().add(BorderLayout.SOUTH, colorbutton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelbutton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        
        frame.setSize(300, 300);
        frame.setVisible(true);       
    } 
    /****************************** Classes Internas ****************************/
     class LabelListener implements ActionListener{ 
         public void actionPerformed(ActionEvent event){
             label.setText("Ouch!");
         }
     }
     
     class ColorListener implements ActionListener{
         public void actionPerformed(ActionEvent event){
             frame.repaint();
         }
     }
    /****************************************************************************/
}
class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        
        Color color = new Color(red, green, blue);
        g.setColor(color);
        
        g.fillOval(50, 100, 50, 50);
    }
}

