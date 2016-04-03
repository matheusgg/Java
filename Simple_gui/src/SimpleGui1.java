import javax.swing.*;

public class SimpleGui1 {

public static void main(String[] args) {   
    
    GUI g = new GUI();
    g.start();
    
    }
}

class GUI{
    public void start(){
        JFrame frame = new JFrame("Meu programa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        
        JButton buttom = new JButton("Clique aqui!");
        
        frame.getContentPane().add(buttom);
        
        frame.setVisible(true);
    }
    
}
