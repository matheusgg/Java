package javaapplication9;

public class JavaApplication9 {

    public static void main(String[] args) {
        Cachorro dog = new Puddle();
        dog.nome = "Little Puddle";
        dog.setNome();
        dog.faz_barulho();    
        dog.anda();
    }
}

class Animal{
    String nome;
    public void faz_barulho(){
        System.out.println("BARULHO!!!");
    }   
}

abstract class Cachorro extends Animal{ // Classes abstratas não podem ser instanciadas  
    public abstract void anda(); // Métodos abstratos não têm corpo     
    public abstract void setNome(); // Métodos abstratos não têm corpo     
}

class Puddle extends Cachorro{    
    public void anda(){
        System.out.println("O puddle está andando!!!");        
    }
    
    public void setNome(){
        System.out.println(nome);        
    }
}

