import java.io.*;
import java.net.*;

public class DailyAdviceServer {
    String[] adviceList = {"Morda pedaços menores", "Use o jeans apertado. Não, ele não faz você parecer gordo(a)", "Só vou dizer uma palavra: Inapropriado", "Pelo menos hoje, seja honesto(a)", "Reconsidere esse corte de cabelo"};

    public void go(){
        try{
            ServerSocket serverSock = new ServerSocket(4242);
            
            while(true){
                Socket sock = serverSock.accept(); // Faz a porta aceitar conexões
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.write(advice);
                writer.close();                
            }
        } catch(IOException ex){ex.printStackTrace();}
    }
    
    public String getAdvice(){
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
    
    public static void main(String[] args) {       
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
