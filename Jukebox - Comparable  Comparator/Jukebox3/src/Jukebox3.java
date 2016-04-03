import java.util.*;
import java.io.*;

public class Jukebox3 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new Jukebox3().go();
    }
    
    class ArtistCompare implements Comparator<Song>{ // Isto fará a classificação por Artísta, dispensando que a classe Song implemente Comparable.
        public int compare(Song one, Song two){
            return one.getArtist().compareTo(two.getArtist());
        }
    }   
    
    public void go(){
        getSongs();
        System.out.println(songList);
        
        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare); // Utiliza o construtor sobrecarregado de sort para classeficar por artísta
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

class Song {
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
        return tittle + ": " + artist; // Retorna a classeficação por artista mostrando o título e o artista
    }
}
