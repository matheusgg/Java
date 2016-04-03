package javaapplication76;
import javax.swing.*;
import java.awt.*;

public class JavaApplication76 extends JPanel{

    public static void main(String[] args) {
        JavaApplication76 j = new JavaApplication76();
        
        JFrame frame = new JFrame("Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.getContentPane().add(j);   
    }
    
    public void paintComponent(Graphics g){       
        Graphics2D g2d = (Graphics2D) g;
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color startColor = new Color(red, red, blue);
        
        int r = (int) (Math.random() * 255);
        int gr = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        Color endColor = new Color(r, gr, b);       
        
        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);       
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
        
        
    }
}

