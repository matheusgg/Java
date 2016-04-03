package javaapplication65;

import java.io.IOException;
import java.util.EmptyStackException;

public class JavaApplication65 {

    public static void main(String[] args) { // Neste código eu estou tratando uma exceção
        Laundry l = new Laundry();
        try{ 
            System.out.println("Primeiro comando do try\n");            
            l.t_shirt("no");            
        } catch (IOException ioex){
            System.out.println("Isso será executado se t_shirt lançou a sua exceção");    
        } catch (EmptyStackException eex){
            System.out.println("Isso será executado se t_shirt lançou sua outra exceção");    
        } finally {
            System.out.println("\nIsso será executado de qualquer jeito"); 
            try{ 
                l.pants();
            } catch (EmptyStackException eex){ // Neste código eu estou tratando uma exceção
                System.out.println("Isso será executado se pants lançou sua exceção\n");    
            }
        }
        System.out.println("Fim.");
        
    }
}

class Laundry{
    public void t_shirt(String set) throws IOException, EmptyStackException{ // Este método pode lançar duas exceções
        if (set.equals("yes")) {
            System.out.println("Exceção da t-shirt");
            throw new IOException();            
        } else{
            System.out.println("Exceção da t-shirt");
            throw new EmptyStackException(); 
        }
    }
    
    public void pants() throws EmptyStackException{ // Este método pode lançar uma exceção
        final int x = 0;
        if (x == 0) {
            System.out.println("Houve uma exceção no método pants");  
            throw new EmptyStackException();            
        }
    }
}

class Wash{ // Aqui estou me livrando da exceção simplesmente declarando-a, porém o método que chamar este método tará que declarar ou tratar esta exceção
    Laundry la = new Laundry();
    public void washing() throws EmptyStackException{ // Quando eu declaro uma exceção eu não preciso de try...catch
        la.pants();
    }
}
