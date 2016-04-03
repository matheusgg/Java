package javaapplication90;
import java.io.*;

public class JavaApplication90 {

    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(120, "Mago", new String[] {"Varinha", "Pó Mágico"});
        GameCharacter two = new GameCharacter(200, "Guerreiro", new String[] {"Espada", "Faca","Punho"});
        GameCharacter three = new GameCharacter(100, "Elfo", new String[] {"Pó", "Varinha"});
        
        try{ /****************************** SERIALIZAÇÃO ***************************************/
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:/Users/Matheus/Downloads/Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (Exception ex){ex.printStackTrace();}
        
        try{ /******************************* DESSERIALIZAÇÃO *************************************/
            ObjectInputStream osi = new ObjectInputStream(new FileInputStream("C:/Users/Matheus/Downloads/Game.ser"));
            GameCharacter g1 = (GameCharacter) osi.readObject();
            GameCharacter g2 = (GameCharacter) osi.readObject();
            GameCharacter g3 = (GameCharacter) osi.readObject();
            
            System.out.println(g1.getClasse() + " : " + g1.getArmas() + " : " + g1.getPower());
            System.out.println(g2.getClasse() + " : " + g2.getArmas() + " : " + g2.getPower());
            System.out.println(g3.getClasse() + " : " + g3.getArmas() + " : " + g3.getPower());
        } catch(Exception ex){ex.printStackTrace();}
        
    }
}

class GameCharacter implements Serializable{
    int power;
    String classe;
    String[] armas;
    
    public GameCharacter(int p, String c, String[] weapons){
        power = p;
        classe = c;
        armas = weapons;        
    }
    
    public int getPower(){
        return power;
    }
    
    public String getClasse(){
        return classe;
    }
    
    public String getArmas(){
        String armas = "";
        for (int i = 0; i < this.armas.length; i++) {
            armas += this.armas[i] + ", ";
        }
        return armas;
    }
}
