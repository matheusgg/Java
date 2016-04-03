package javaapplication50;

public class JavaApplication50 {     

    public static void main(String[] args) {
        Numb num = new Numb();
        num.stNum(10);
        num.stNum2(20);
        
        TestePoli2 tp = new TestePoli2();
        tp.start();       
    }
}   


class Number{
    int num1;
    int num_qualquer = (int) (Math.random() * 5);
    
    public void stNum(int x){
        int result = x + num1 + num_qualquer;
        System.out.println(result);       
    }   
    
    public void stNum2(int x){
        int result = x - num1 - num_qualquer;
        System.out.println(result);       
    }
    
    public void poli(){        
        System.out.println("Polimorfismo funciona mesmo!!!");
    }
}

class Numb extends Number{
    
    public void stNum(int x){
        int result = x + num1 - num_qualquer;
        System.out.println(result);  
    }
}

class TestePoli{
    
    public void polimorfismo (Numb n){
        n.poli();        
    }   
}

class TestePoli2{
    public void start(){
        TestePoli tp = new TestePoli();
        Numb nb = new Numb();
        tp.polimorfismo(nb);       
    }   
}
