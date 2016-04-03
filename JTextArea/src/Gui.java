import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui implements ActionListener{
    private JTextArea text_area;   
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    
    public Gui(){
        frame = new JFrame("Application");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  
    }

    public static void main(String[] args) {        
        Gui g = new Gui();
        g.go();        
    }
    
    public void go(){       
        text_area = new JTextArea();
        text_area.setLineWrap(true);
        text_area.setText("Clique no botão.\n");
        
        JScrollPane scroll = new JScrollPane(text_area);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);        
        
        button = new JButton("Clique aqui!");
        button.addActionListener(this);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        panel.add(scroll);

        frame.getContentPane().add(BorderLayout.CENTER, panel); 
        frame.getContentPane().add(BorderLayout.SOUTH, button);       
    }
    
    public void actionPerformed(ActionEvent event){
        text_area.append("Você clicou no botão!!!\n");
    }
}
