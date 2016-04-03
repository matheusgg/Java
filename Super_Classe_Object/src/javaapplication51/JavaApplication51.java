package javaapplication51;

import java.util.ArrayList;

public class JavaApplication51 {

    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();
        MyAnimalList list = new MyAnimalList();
        list.add(d);
        list.add(c);
        
        System.out.println(list.getClass()); // Mosta o nome completo da classe onde o objeto foi instanciado
        System.out.println(list.hashCode()); // Mostra uma identificação exclusiva da classe
        System.out.println(list.toString()); // Mostra uma mensagem em string com algumas letras e números  
        
        ArrayList<Object> al = new ArrayList<Object>(); // ArrayList do tipo Object
        al.add(c); // Adicionei um objeto Cat pois Cat estende Object      
        
        if (al.get(0) instanceof Cat) { // Verifica se o objeto do índice 0 de al é instância de Cat
            Cat gato = (Cat) al.get(0); // Peguei da ArrayList o objeto que está no índice 0, porém ele veio como Object, então forçei uma conversão para o tipo Cat.            
        }
        
    }
}

abstract class Animal{    
    
}

class Dog extends Animal{
    
}

final class Cat extends Animal{ // O "final" significa que nenhuma classe pode estender (herdar) de Cat
    
}

class MyAnimalList{
    private Animal[] animals = new Animal[5];
    private int nextindex = 0;
    
    public void add(Animal a){
        if (nextindex < animals.length) {
            animals[nextindex] = a;
            System.out.println("Animal adicionado em " + nextindex);
            nextindex++;
        }       
    }
}

        
        
        