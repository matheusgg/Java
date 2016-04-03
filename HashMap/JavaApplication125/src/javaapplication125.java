import java.util.*;

public class javaapplication125 {

    public static void main(String[] args) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>(); // Conjuntos HashMap possui uma CHAVE e um VALOR
        
        
        map.put("Rose", 43); // adiciona uma CHAVE e um VALOR
        
        map.put("Nelson", 53); // Você pode ter valores duplicados em um HashMap
        map.put("Matheus", 53); // Você pode ter valores duplicados em um HashMap
        
        
        map.put("Carlos", 18); // Mas não é possível ter chaves duplicadas
        map.put("Carlos", 50); // Mas não é possível ter chaves duplicadas, então o somente a última chave adicionada é utilizada
        
        
        System.out.println(map); // Imprime na tela tanto a chave quanto o valor
        System.out.println(map.get("Carlos")); // Imprime na tela somente o valor da chave "Rose"
    }
}

