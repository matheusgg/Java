package javaapplication60;

public class JavaApplication60 {

    public static void main(String[] args) {
        System.out.println(Teste.cont); // Para acessar variáveis ou métodos estáticos basta chamar o nome da classe.método ou variável
        Teste t = new Teste();  
        System.out.println(Teste.cont);
        Teste t2 = new Teste();
        System.out.println(Teste.cont);
        System.out.println(Teste.X + " e " + Teste.Y);        
    }
}

class Teste{
    static int cont; // Essa variável estática será compartilhada por todos os objetos criados, ela pertençe somente a classe (não precisa ser inicializada)
    public static final int X = 25; // Variáveis finais não mudam seu valor, isto é, sempre será o valor definido ou o padrão (Voce deve inicializar a variavel quando declará-la)
    public static final double Y; // VARIÁVEIS ESTÁTICAS FINAIS DEVEM SEMPRE SER MAIÚSCULAS
    final int z; //Uma variável final não-estática deve ser inicializada na sua declaração ou no construtor
    
    static{ // Ou você deve inicializar a variável final dentro de um inicializador estático (se ela for estática), que é o bloco de código que será executado antes de tudo!
        Y = 5.6;        
    }
    
    Teste(){
        super();
        cont++;
        z = 0; //Uma variável final não-estática deve ser inicializada na sua declaração ou no construtor
    }  
}

class Teste_2{
    private Teste_2(){ // Isso significa que códigos externos não podem instanciar essa classe, pois seu construtor está privado
        super();
    }
    
    public final void teste_metodo(){ // Um método final não pode ser sobreposto
        System.out.println("Teste de método final");
    }
}
