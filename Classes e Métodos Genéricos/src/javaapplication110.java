public class javaapplication110 {

    public static void main(String[] args) {
        Teste<String> t = new Teste<String>();
        t.go("Nome: Matheus. \nIdade: ");
        
        Teste_2 t2 = new Teste_2();
        t2.go(18);
        t2.go_2("\n\nFim.\n");         
    }
}

/************************** DECLARAÇÃO DE CLASES E MÉTODOS GENÉRICOS *************************/
class Teste<E>{ // Isso significa que foi reservado um espaço na memória para o tipo paramentrizado.
    public void go(E o){ // Já que "E" foi utilizado na declaração da classe, pode ser utilizado aqui também, pois será modificado de acordo com o tipo que será inserido na classe
        System.out.print(o);
        
    }
}

class Teste_2{
    public <T> void go(T o){ // Quando a classe não possui uma declação de tipo, podemos declarar no próprio método e utilizar como parâmetro.
        System.out.print(o);
    }
    public <T extends String> void go_2(T o){ // Podemos também já definir o tipo parametrizado do método. Neste caso, a palavra extends pode significar tando "extends" (para classes) quando "implements" (para interfaces).
        System.out.print(o);
    }   
}