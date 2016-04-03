import java.io.*;

public class Gravar_String {

    public static void main(String[] args) {
        try{
            FileWriter fw = new FileWriter("C:/Users/Matheus/Downloads/Teste.txt");
            fw.write("Isto é um teste!!!");
            fw.write("\r\nContinuação do teste.");
            fw.close();            
                        
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
