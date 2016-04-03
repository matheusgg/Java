import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleGui extends JPanel{
    JFrame frame;
    JLabel label;
    

    public static void main(String[] args) {
        /*SimpleGui gui = new SimpleGui();
        gui.go();*/  
        
        Animacao anim = new Animacao();
        anim.go();
    }
    
    public void go(){
        frame = new JFrame("Treinando...");
        label = new JLabel("Hey yo!");        
        
        JButton colorbutton = new JButton("Mudar Cor!!!");
        JButton labelbButton = new JButton("Mudar Texto!!!");
        
        colorbutton.addActionListener(new Button());
        labelbButton.addActionListener(new Label());
        
        frame.getContentPane().add(BorderLayout.EAST, label);
        frame.getContentPane().add(BorderLayout.NORTH, labelbButton);
        frame.getContentPane().add(BorderLayout.SOUTH, colorbutton);
        
        SimpleGui draw = new SimpleGui();
        
        frame.getContentPane().add(BorderLayout.CENTER, draw);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
        
    }
    
    class Label implements ActionListener{
        public void actionPerformed(ActionEvent event){
            label.setText("Hey.. clicado!");
        }
    }
    
    class Button implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            frame.repaint();        
        }
    }
    
    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color startColor = new Color(red, green, blue);
        
        int r = (int) (Math.random() * 255);
        int gr = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        Color endColor = new Color(r, gr, b);       
        
        GradientPaint gradiente = new GradientPaint(50, 100, startColor, 50, 100, endColor);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(gradiente);
        g2d.fillOval(100, 80, 50, 50);      
    }
}

class Animacao extends JPanel{
    static int x = 70, y = 70;
    public void go(){
        JFrame frame = new JFrame("Animação");       
        //MyDraw draw = new MyDraw(); 
        Animacao draw = new Animacao();
        frame.getContentPane().add(draw);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
        
        for (int i = 0; i < 130; i++) {
            x++;
            y++;
            draw.repaint();
            try{
                Thread.sleep(25);
            } catch(Exception ex){}           
        }         
    }
    
    //class MyDraw extends JPanel{  
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
            g.setColor(Color.green);
            g.fillOval(this.x, this.y, 50, 50);        
        }
    }
//}