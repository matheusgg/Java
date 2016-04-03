package javaapplication52;

public class JavaApplication52 {

    public static void main(String[] args) {
        Lion li = new Lion();
        li.andar();
        li.comer();
        
        Dog d = new Dog();
        d.andar();
        d.brincar();
        d.correr();
        d.ser_amigavel();
        d.comer(); 
        
        System.out.println(""); 
        
        Mouse m = new Mouse();
        m.andar();
        m.comer();
                
        System.out.println(""); 
        
        Pet[] p = new Pet[2];
        p[0] = new Dog();
        p[0].brincar();
    }
}

abstract class Animal{
    public void comer(){
        System.out.println("O animal está comendo.");        
    }
    
    public void andar(){
        System.out.println("O animal está andando.");        
    }    
}

/****************************** INTERFACES ***********************************/
interface Pet{
    /*abstract public*/ void brincar();
    abstract public void correr();   
}

interface Pet_2{
    void ser_amigavel();    
}
/*****************************************************************************/

final class Lion extends Animal{ 
    @Override
    public void comer(){
        System.out.println("O animal está comendo muito!!!\n");        
    }   
}

final class Dog extends Animal implements Pet, Pet_2{
    @Override
    public void brincar(){
        System.out.println("O animal está brincando...");            
    }
    
    @Override
    public void correr(){
        System.out.println("O animal está correndo...");        
    }
    
    @Override
    public void ser_amigavel(){
        System.out.println("O animal está sendo amigável...");        
    }
}

class Mouse extends Animal{
    @Override
    public void andar(){ // Sobrepõe o método andar da superclasse Animal
        super.andar(); // Porém, chama o método de volta com a palavra "super", isso se chama SOBRECARGA DE MÉTODO
        System.out.println("O ratinho está andando muito rápido!!!"); // E complementa com mais este código      
    }   
}

