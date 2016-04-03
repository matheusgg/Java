public class Sinal {
    String sinal;
    Carro c1 = new Carro();
        
    public void sinalVermelho(){
        sinal = "vermelho";
        System.out.println("O sinal está "+ sinal + "!");   
        c1 = new Carro();
        c1.parado();
    }
    
    public void sinalAmarelo(){
        sinal = "amarelo";
        System.out.println("O sinal está "+ sinal + "!");  
        c1 = new Carro();
        c1.parar();
    }
    
    public void sinalVerde(){
        sinal = "verde";
        System.out.println("O sinal está "+ sinal + "!");         
        c1 = new Carro();
        c1.acelerar();
    }
    
}
