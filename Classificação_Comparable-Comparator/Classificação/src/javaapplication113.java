import java.util.*;
import java.io.*;

public class javaapplication113 {  
    ArrayList<People> list = new ArrayList<People>();
    
    public static void main(String[] args) {
        new javaapplication113().go();        
    }
    
    public void getDados(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Matheus/Downloads/People.txt"));
            String linha = null;
            while((linha = reader.readLine()) != null){
                addDados(linha);
            }
        } catch(Exception ex){ex.printStackTrace();}
    }
    
    public void addDados(String p){
        String[] pessoas = p.split("/");
        People pp = new People(pessoas[0], Integer.parseInt(pessoas[1]));
        list.add(pp);
    }
    
    public void go(){
        getDados();
        System.out.println(list);
        Collections.sort(list, new Pessoas_List());
        System.out.println(list);
    }
    
    public class Pessoas_List implements Comparator<People>{
        public int compare(People one, People two){            
            return ((Integer) one.getIdade()).compareTo((Integer) two.getIdade());
        }
    }
}

class People {
    private String nome;
    private int idade;
    
    public People(String n, int i){
        nome = n;
        idade = i;            
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public int compareTo(People p){
        return nome.compareTo(p.getNome());
    }
    
    public String toString(){       
        return nome + ": " + idade;
    }
}
