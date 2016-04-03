import java.util.*;

public class javaapplication124 {
    
    public static void main(String[] args) {
       new javaapplication124().go();
       
       System.out.println("\n");
       
       new javaapplication124().go2();
    }
    
    public void go(){
        Songs s1 = new Songs("I Gotta Feeling");
        Songs s2 = new Songs("Boom Boom Pow");
        Songs s3 = new Songs("Meet Me Halfway");
        Songs s4 = new Songs("Imma Be");
        Songs s5 = new Songs("I Gotta Feeling");
        
        TreeSet<Songs> ts = new TreeSet<Songs>(new Book_List()); // TreeSet pode ser usado com o contrutor sobrecarregado passando um objeto que implemente Comparator para ele.
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        
        System.out.println(ts);
    }    
    
    public class Book_List implements Comparator<Songs> { // Classe que implementa Comparator
        public int compare(Songs one, Songs two){
            return one.tittle.compareTo(two.getTittle());            
        }
    }  
    
    public void go2(){
        Songs_2 s1 = new Songs_2("I Gotta Feeling");
        Songs_2 s2 = new Songs_2("Boom Boom Pow");
        Songs_2 s3 = new Songs_2("Meet Me Halfway");
        Songs_2 s4 = new Songs_2("Imma Be");
        Songs_2 s5 = new Songs_2("I Gotta Feeling");
        
        TreeSet<Songs_2> ts = new TreeSet<Songs_2>(); // TreeSet também pode ser usando usando apenas um tipo parametrizado que implementa Comparable
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        
        System.out.println(ts);
    }
}

class Songs{
    String tittle;
    public Songs(String t){
        tittle = t;
    }
    
    public String getTittle(){
        return tittle;
    }
    
    public String toString(){
        return tittle;
    }
}

class Songs_2 implements Comparable<Songs_2> {
    String tittle;
    public Songs_2(String t){
        tittle = t;
    }
    
    public String getTittle(){
        return tittle;
    }
    
    public int compareTo(Songs_2 s){
        return tittle.compareTo(s.getTittle());
    }
    
    public String toString(){
        return tittle;
    }
}
