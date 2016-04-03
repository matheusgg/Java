import java.util.*;

public class javaapplication126 {

    
    public static void main(String[] args) {
        HashMap<Integer, Song> map = new HashMap<Integer, Song>(); // HashMap não implementa a interface Collections, então não há como classificar      
        
        map.put(5, new Song("I Gotta Feeling"));
        map.put(1, new Song("Boom Boom Pow"));
        map.put(4, new Song("Imma Be"));
        map.put(2, new Song("Rock That Body"));
        map.put(3, new Song("Meet Me Halfway"));        
        
        System.out.println(map);
        
    }
}

class Song {
    private String tittle;
    
    public Song(String t){
        tittle = t;
    }
    
    public String getTittle(){
        return tittle;
    }
    
    public String toString(){
        return tittle;
    }
}
