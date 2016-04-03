import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener{
    JButton buttom; 

    public static void main(String[] args) {
       SimpleGui1B gui = new SimpleGui1B();
       gui.go();
       
    }
    
    public void go(){
        JFrame frame = new JFrame("Meu Programa");
        Gui g = new Gui();
        g.setSize(50, 50);
        
        buttom = new JButton("Clique me");
        
        buttom.addActionListener(this);
        
        frame.getContentPane().add(g);
        //frame.getContentPane().add(buttom);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event){
        buttom.setText("Eu fui clicado :D");
    }      
}

class Gui extends JPanel{
    public void paintComponent(Graphics g){
        g.setColor(Color.red);
        Image i = new ImageIcon("C:/Users/Public/Pictures/Sample Pictures/articfox.jpg").getImage();
        g.drawImage(i, 2, 2, this);
        
        
    }
}
