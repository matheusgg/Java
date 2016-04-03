import java.net.*;
import java.io.*;

public class Rede_Class {

    public static void main(String[] args) {
        try{
            /************************* PARA CONECTAR A UM SERVIDOR ***************************/
            Socket chatSocket = new Socket("127.0.0.1", 5000); // Cria uma conexão de Socket com o servidor
            InputStreamReader stream = new InputStreamReader(chatSocket.getInputStream()); // Recebe o fluxo de bytes do servidor (em baixo nível)
            BufferedReader reader = new BufferedReader(stream); // Aqui os fluxos são lidos em alto nível
            String message = reader.readLine();
            System.out.println(message);
            
            /************************* PARA ESCREVER EM UM SOCKET ***************************/
            PrintWriter writer = new PrintWriter(chatSocket.getOutputStream()); // Podemos usar tanto o Print quanto o BufferedWriter, porém PrintWriter é o padrão
            writer.print("Message to send");
            writer.println("Another message");
            writer.close();            
            
            /************************* PRINTWRITER FAZ A MESMA COISA QUE BUFFEREDWRITER ***************************/
            /*PrintWriter pw = new PrintWriter(new FileWriter("C:/Users/Matheus/Downloads/Teste.txt"));
            pw.print("Teste\r\n");
            pw.print("Teste 2.");
            pw.close();*/
            
        } catch(IOException ex){ex.printStackTrace();}
        
        
    }
}
