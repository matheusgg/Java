import javax.swing.*;
import java.awt.event.*;

public class javaapplication151 {
        static JLabel label = new JLabel();

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();        
        
        JButton button = new JButton("Clique");
        
        /************************ Classe Anônima **************************/
        button.addActionListener(new ActionListener() { // Isto na verdade cria uma nova classe anônima (sem nome) que implementa a interface ActionListener

            public void actionPerformed(ActionEvent e) { // Todo o código da nova classe anônima vai dentro do chamador do método onde nós passaríamos os argumentos
                label.setText("Você clicou!!!");
            }
        }/* A classe anônima termina aqui */);
        
        panel.add(label);
        panel.add(button);
        
        frame.getContentPane().add(panel);
    }
}
