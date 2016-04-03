import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Song_Test {
    ArrayList<Song> list = new ArrayList<Song>();
    
    public static void main(String[] args) {
        new Song_Test().go();
    }
    
    public void go(){
        getDados();
        System.out.println(list);
        TreeSet<Song> ts = new TreeSet<Song>(); // Cria um novo objeto treeset que não repete e classifica por título
        ts.addAll(list);
        System.out.println(ts);
    }
    
    public void getDados(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Users/Matheus/Downloads/Songs.txt")));
            String linha = null;
            while((linha = reader.readLine()) != null){
                addLinha(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addLinha(String linha){
        String[] token = linha.split("/");
        Song s = new Song(token[0], token[1], (Integer.parseInt(token[2])));
        list.add(s);
    }
}

class Song implements Comparable<Song>{
    private String tittle;
    private String artist;
    private int num;
    
    public Song(String t, String a, int n){
        tittle = t;
        artist = a;
        num = n;        
    }
    
    public String getTittle(){
        return tittle;
    }
    
    public String getArtist(){
        return artist;
    }
    
    public int getNum(){
        return num;
    }
    
    public String toString(){
        return tittle;
    }
    
    public int compareTo(Song s){
        return getTittle().compareTo(s.getTittle()); // Faz treeset classificar por título
    }
}
