package javaapplication61;

import java.util.ArrayList;

public class JavaApplication61 {

    public static void main(String[] args) {       
       Character ch = new Character('c'); // Isso se chamado empacotador, todos os tipos primitivos tem um empacotador, antes do Java 5 serviar para criar referências de objetos para serem inseridas por exemplo em ArrayLists
       char cha = ch.charValue(); // Desempacotador
       
       Integer in = new Integer(5);// Isso se chamado empacotador, todos os tipos primitivos tem um empacotador, antes do Java 5 serviar para criar referências de objetos para serem inseridas por exemplo em ArrayLists
       int inte = in.intValue();// Desempacotador
       
       ArrayList<Character> charac = new ArrayList<Character>(); // ArrayList de Characteres
       charac.add(ch);       
       char teste = charac.get(0);
       System.out.println(teste);
       
       ArrayList al = new ArrayList(); // ArrayList Genérica (do tipo Object)
       
       al.add(new Integer(3)); // Adicionei um tipo primitivo int empacotado     
       al.add("Matheus"); // OU // al.add(new String("Matheus")); // Adicionei um tipo primitivo String empacotado
       
       Integer teste_int = (Integer) al.get(0); //Extrai o valor empacotado (ele vem como Object) e converti para Integer
       String teste_string = (String) al.get(1); //Extrai o valor empacotado (ele vem como Object) e converti para String
       
       int int_final = teste_int.intValue(); //Desempacotei o valor e o atribuia uma variável int
       
       System.out.println(int_final);
       System.out.println(teste_string);
       
       
       
    }
}
