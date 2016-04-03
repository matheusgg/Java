import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Simple_Gui {
    private JFrame frame;
    private JTextArea textArea;  
    
    public Simple_Gui(){
        frame = new JFrame("Aplicação");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        Simple_Gui app = new Simple_Gui();
        app.go();                
    }
    
    public void go(){
        JPanel mainPanel = new JPanel();    
        
        Font fonte = new Font("calibri", Font.BOLD, 16);
        
        textArea = new JTextArea(8, 10);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(fonte);
        
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JButton button = new JButton("Clique para limpar");
        button.addActionListener(new Button_Listener());
        
        mainPanel.add(scroll);
        mainPanel.add(button);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Arquivo");
        JMenuItem saveItem = new JMenuItem("Salvar");
        JMenuItem openItem = new JMenuItem("Abrir...");
        
        saveItem.addActionListener(new Save());
        openItem.addActionListener(new Open());
        
        menu.add(openItem);
        menu.add(saveItem);
        
        menuBar.add(menu);
        
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);       
    }
    
    public class Button_Listener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            textArea.setText("");
        }
    }
    
    public class Save implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(frame);
            setSaveFile(fc.getSelectedFile());
        }        
    }
    
    public class Open implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(frame);
            setOpenFile(fc.getSelectedFile());                        
        }
    }
    
    private void setSaveFile(File f){
        String text = textArea.getText();        
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(f + ".txt"));
            writer.write(text);
            writer.close();
        } catch(IOException ex){ex.printStackTrace();}
    }
    
    private void setOpenFile(File f){
        String linha = null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(f));
            linha = reader.readLine();
            reader.close();
            textArea.setText(linha);
        } catch(IOException ex){ex.printStackTrace();}
    }
}


