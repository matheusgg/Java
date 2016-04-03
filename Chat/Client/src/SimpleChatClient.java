import java.io.*;
import java.net.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class SimpleChatClient {

    JTextField outgoing;
    PrintWriter writer;
    Socket sock;
    
    public static void main(String[] args) {
        new SimpleChatClient().go();        
    }
    
    public void go(){
        JFrame frame = new JFrame("Simple Chat Client");
        JPanel mainpanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendbutton = new JButton("Send");
        sendbutton.addActionListener(new SendButtonListener());
        mainpanel.add(outgoing);
        mainpanel.add(sendbutton);
        frame.getContentPane().add(BorderLayout.CENTER, mainpanel);
        setUpNetworking();
        frame.setSize(400, 100);
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setUpNetworking(){
        try{
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        } catch(IOException ex){ex.printStackTrace();}
    }
    
    public class SendButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            try{
                writer.println(outgoing.getText());
                writer.flush();
            } catch(Exception ex){
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }        
    }
}
