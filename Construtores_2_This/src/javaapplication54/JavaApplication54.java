package javaapplication54;

public class JavaApplication54 {

    public static void main(String[] args) {
        Dog d = new Dog();      
    }
}

class Animal{
    public Animal(int size){
        System.out.println("Objeto criado!!!... " + size);
    }
}

class Dog extends Animal{
    public Dog(){
        this(5); // Este comando faz o CONSTRUTOR SOBRECARREGADO ser executado, isto é, quando o compilador chegar aqui, ela pulará para o outro construtor da classe Dog (que está sobrecarregado)
        System.out.println("Teste...");
    }
    
    public Dog(int size){
        super(size);
        System.out.println("O tamanho do cachorro é: " + size);
    }
}
