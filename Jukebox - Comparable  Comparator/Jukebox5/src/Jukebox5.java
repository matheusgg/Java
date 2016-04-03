import java.util.*;
import java.io.*;

public class Jukebox5 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new Jukebox5().go();
    }
    
    public void go(){
        getSongs();
        System.out.println(songList);
        Collections.sort(songList); // Usa o método sort para classificar por artista
        System.out.println(songList);       
    }
    
    void getSongs(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Users/Matheus/Downloads/SongList.txt")));
            
            String linha = null;
            while((linha = reader.readLine()) != null){
                addSong(linha);
            }
        } catch(Exception ex){ex.printStackTrace();}
    }
    
    void addSong(String lineToParse){
        String[] tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}

class Song implements Comparable<Song> { // Torna a classificação por título padrão
    String tittle;
    String artist;
    String rating;
    String bpm;
    
    public int compareTo(Song s){
        return tittle.compareTo(s.getTittle());        
    }
    
    Song(String t, String a, String r, String b){
        tittle = t;
        artist = a;
        rating = r;
        bpm = b;
    }
    
    public String getTittle(){
        return tittle;
    }
    
    public String getArtist(){
        return artist;
    }
    
    public String getRating(){
        return rating;
    }
    
    public String getBpm(){
        return bpm;
    }
    
    public String toString(){
        return tittle;
    }
}
