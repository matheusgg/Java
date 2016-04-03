package javaapplication46;

import java.util.ArrayList;

public class JavaApplication46 {


    public static void main(String[] args) {
       /******************************************************************/
        // For Aperfeiçoado:        
        String[] chamada = {"Matheus", "Rosemeire", "Nelson"};
        
        for (String nome : chamada) {
            // .equals
            if (nome.equals("Nelson")) {
                System.out.println("Ei! Este é o nome do meu pai... " + nome);
                break;
            } else{
                System.out.println(nome);               
            }        
        }
       /******************************************************************/
        // ArrayList
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Matheus");
        myList.add("Rose");
        myList.add(2, "Nelson");       
        
        boolean contem = myList.contains("Matheus");
        System.out.println("\nEste ArrayList possui o nome " + myList.get(0));
        
        int size = myList.size();
        System.out.println("Este ArrayList possui " + size + " elementos");
        /******************************************************************/
        // Encapsulamento
        Encapsulamento ec = new Encapsulamento();
        ec.calculaNum(2, 8);        
    }
}

class Encapsulamento{
    private int num1, num2, result;
    // Encapsulamento
    public void calculaNum(int number1, int number2){
        
        if (number1 <= 0 || number2 <=0) {
            System.out.println("\nEstes números não serão somados pois são menores ou iguais a 0.");           
        } else{
            num1 = number1;
            num2 = number2;
            result = num1 + num2;
            System.out.println("\nA soma de " + num1 + " + " + num2 + " é igual a " + result);   
        }       
    }  
}