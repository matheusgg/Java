import java.io.*;

public class Save_Read {

    public static void main(String[] args) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:/Users/Matheus/Downloads/Teste.txt")));
            writer.write("Meu nome é Matheus\r\n");
            writer.write("E tenho 18 anos.\r\n");
            writer.write("$%&¨¬#!");
            writer.close();
        } catch (IOException ex){ex.printStackTrace();}
        
        try{
            File file = new File("C:/Users/Matheus/Downloads/Teste.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);            
            //^ Isto é a mesma coisa disto:
            //BufferedReader reader2 = new BufferedReader(new FileReader(new File("C:/Users/Matheus/Downloads/Teste.txt")));
            
            String linha = null;
            while((linha = reader.readLine()) != null){
                System.out.println(linha);
            }
            reader.close();
            
        } catch(IOException ex){ex.printStackTrace();}
        
    }
}
