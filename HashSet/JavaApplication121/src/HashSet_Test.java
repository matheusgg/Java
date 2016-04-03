import java.util.*;
import java.io.*;

public class HashSet_Test {
    ArrayList<People> list = new ArrayList<People>();
    
    public static void main(String[] args) {
        new HashSet_Test().go();
       
    }
    
    public void go(){
        getDados();
        System.out.println(list);
        
        HashSet<People> hash = new HashSet<People>(); // Cria um novo hashSet
        
        hash.addAll(list);
        
        System.out.println(hash);
    }
    
    public void getDados(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Users/Matheus/Downloads/People.txt")));
            String linha = null;
            while((linha = reader.readLine()) != null){
                addLinha(linha);
            }
        }catch(IOException ex){ex.printStackTrace();}
    }
    
    public void addLinha(String linha){
        String[] token = linha.split("/");
        People p = new People(token[0], (Integer.parseInt(token[1])));
        list.add(p);
    }
    
    public class Idade_List implements Comparator<People>{
        public int compare(People one, People two){
            return ((Integer) one.getIdade()).compareTo((Integer) two.getIdade());
        }
    }
    
    
}

class People /*implements Comparable<People>*/ {
    private String nome;
    private int idade;
    
    public People(String n, int i){
        nome = n;
        idade = i;
    }
    
    public String getNome(){
        return  nome;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public String toString(){
        return nome + ": " + idade;
    }
    
    public int hashCode(){ // Isso impede duplicatas no hashSet
        return nome.hashCode();
    }
    
    public boolean equals(Object o){// Isso impede duplicatas no hashSet
        People p = (People) o;
        return getNome().equals(p.getNome());
    }
    
    public int compareTo(People p){
        return nome.compareTo(p.getNome());
    }
    
    
}
