package javaapplication19;
import java.io.*;

public class JavaApplication19 {

    public static void main(String[] args) {
        Save_Test save = new Save_Test();
        save.setWidth(30);
        save.setHeight(50);
        
        try{
            FileOutputStream fs = new FileOutputStream("C:/Users/Matheus/Downloads/save.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(save);
            os.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }        
    }
}

class Save_Test implements Serializable{
    private int width;
    private int height;
    transient Save_Test_2 sav = new Save_Test_2(); // Com isso, a variável de instância não será salva, isto é, ela será ignorada no processo de serialização, pois está marcada com transient
    
    public void setWidth(int w){
        width = w;
    }
    
    public void setHeight(int h){
        height = h;
    }
}

class Save_Test_2{
    static final int X = 10;
}