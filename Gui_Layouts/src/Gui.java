import javax.swing.*;
import java.awt.*;

public class Gui {

    public static void main(String[] args) {
        /*Border_Layout b = new Border_Layout();
        b.go();*/
        
        /*Flow_Layout f = new Flow_Layout();
        f.go();*/
        
        Box_Layout b= new Box_Layout();
        b.go();        
        
    }    
    
}
class Border_Layout{ // GERENCIADOR DE LAYOUT **** BORDER LAYOUT ****
    public void go(){
        JFrame frame = new JFrame("Swing");
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                
        JButton north = new JButton("north");
        JButton south = new JButton("south");
        JButton east = new JButton("east");
        JButton west = new JButton("west");
        JButton center = new JButton("center");
        
        
        frame.getContentPane().add(BorderLayout.NORTH, north);
        frame.getContentPane().add(BorderLayout.SOUTH, south);
        frame.getContentPane().add(BorderLayout.EAST, east);
        frame.getContentPane().add(BorderLayout.WEST, west);
        frame.getContentPane().add(BorderLayout.CENTER, center);
    }    
}

class Flow_Layout{// GERENCIADOR DE LAYOUT **** FLOW LAYOUT ****
    public void go(){
        JFrame frame = new JFrame("Swing");
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        
        JButton button = new JButton("shock me!");
        JButton buttonTwo = new JButton("bliss");
        JButton buttonThree = new JButton("huh?");
        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonThree);
        
        frame.getContentPane().add(BorderLayout.EAST, panel);
        
    }
}

class Box_Layout{// GERENCIADOR DE LAYOUT **** BOX LAYOUT ****
    public void go(){
        JFrame frame = new JFrame("Swing");
        frame.setSize(250, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel painel = new JPanel();
        painel.setBackground(Color.gray);
        
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        
        JButton buttonOne = new JButton("Shock me!");
        JButton buttonTwo = new JButton("bliss");
        
        painel.add(buttonOne);
        painel.add(buttonTwo);
        
        //frame.setContentPane(painel); <== Define o JPanel como o painel de conteúdo da moldura
        frame.getContentPane().add(BorderLayout.EAST, painel);
    }
}
