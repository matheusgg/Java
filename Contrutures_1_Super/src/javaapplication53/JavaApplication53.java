package javaapplication53;

public class JavaApplication53 {
    
    public static void main(String[] args) {
    Duck d = new Duck();  
    Dog cachorro = new Dog();
    cachorro.mostrar();
    cachorro.mensagem();
    
    Hipoo h = new Hipoo("Hipopótamo");
    }
}

class Duck{
    int size;

    /*************************************************CONSTRUTOR***************************************************************/
    private Duck(int tamanho){ // ISTO É UM CONSTRUTORRRR!!!!!!!! A diferença dele para um método é que não há um tipo de retorno        
        size = tamanho; // No construtor podemos inicializar variáveis da classe
        System.out.println("Quack!... Objeto criado com o tamanho " + size);
    }
    
    /*************************************************CONSTRUTOR***************************************************************/
    public Duck(){// ISTO É UM CONSTRUTORRRR!!!!!!!! A diferença dele para um método é que não há um tipo de retorno (Obs.: Este construtor não possui parâmetros!!!)        
        size = 17; // No construtor podemos inicializar variáveis da classe
        System.out.println("Quack!... Objeto criado com o tamanho " + size);        
    }
    
}

interface Teste{
    abstract public void mostrar();    
}

abstract class Animal{
     public void mensagem()   {
         System.out.println("Olá!!!\n");        
     }
}

final class Dog extends Animal implements Teste{
    Dog(){ // Isso é a mesma coisa que "public Dog", isto é, um construtor público
        System.out.println("Feito!");        
    }
    
    public void mostrar(){
        System.out.println("Mensagem...");        
    }    
}


abstract class Animal2{
    public Animal2(String nome_animal){
        System.out.println("Criando o objeto animal... " + nome_animal);
    }    
    
    public void mostrar_algo(){
        System.out.println("Mensagem qualquer");
    }
}

final class Hipoo extends Animal2{
    
    public Hipoo(String nome_animal){
        super(nome_animal); //Chama o superconstrutor, isto é, chama o construtor de Animal2 e passa o argumento 5. Se não fizermos isso, o compilador o fará
        System.out.println("Criando o objeto hipoo...");      
    }  
}

