import java.io.*;

public class Split_Test {

    public static void main(String[] args) {
        String frase = "Qual é o seu nome?/Meu nome é Matheus.";
        
        String[] result = frase.split("/"); // Este método separa a frase usando a "/" como parâmetro
        for(String phrase : result){
            System.out.println(phrase);
        }
    }
}
