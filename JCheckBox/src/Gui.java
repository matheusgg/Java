import javax.swing.*;
import java.awt.event.*;

public class Gui{

    public static void main(String[] args) {
        Check ch = new Check();
        ch.go();        
    }
}

class Check implements ItemListener{ // JCheckBox
    JLabel label;
    JCheckBox check;
    
    public void go(){
        JFrame frame = new JFrame("Application");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        label = new JLabel();
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        check = new JCheckBox("Selecione");
        check.setSelected(false);
        check.addItemListener(this);
        
        panel.add(check);  
        panel.add(label);       
        
        frame.setContentPane(panel);
    }
    
    public void itemStateChanged(ItemEvent ev) {
        if (check.isSelected()) {            
            label.setText("Você selecionou!!!");
        }  else{
            label.setText("");
        }
    }
}
