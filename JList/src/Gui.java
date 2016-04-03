import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.*;

public class Gui {

    public static void main(String[] args) {
        J_List l = new J_List();
        l.go();       
    }
}

class J_List implements ListSelectionListener{
    private JLabel label = new JLabel();
    private JList list;
    
    public void go(){
        JFrame frame = new JFrame("Lista de times");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true); 
        
        String[] times = {"Pamleiras", "São Paulo", "Corinthians","Santos", "Flamengo", "Fluminense", "Botafogo", "Vasco"};
        list = new JList(times);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(4); // Exibe somente 4 itens de cada vez
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Faz selecionar uma coisa de cada vez
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JScrollPane scroll = new JScrollPane(list);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        panel.add(scroll);
        frame.getContentPane().add(BorderLayout.SOUTH, label);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
    }
    
    public void valueChanged(ListSelectionEvent lse){
        String item = (String) list.getSelectedValue();
        label.setText(item);    
    }
}
