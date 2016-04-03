package javaapplication13;
import javax.sound.midi.*;
public class JavaApplication13 {

    public static void main(String[] args) {
        Sound s = new Sound();
        try{ // Aqui o código que lança uma exceção é executado
            s.play();
        } catch(Exception ex){ // Se ocorrer alguma coisa (alguma exceção), a exceção será tratada aqui
            System.out.println("Exeption");
        }
    }
}

class Sound {
    private static final int x = 5;
    public void play() throws Exception{ // Este método lança uma exceção
        System.out.println("Teste de exception");        
        if (x == 5) {
            throw new Exception(); // Toda vez que um método lançar uma exceção, um novo objeto Exception deve ser lançado         
        }
    }   
}


