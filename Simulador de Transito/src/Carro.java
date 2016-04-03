public class Carro {
    
    int velocidade;
    
    public void acelerar(){
        velocidade = (int) (Math.random() * 10);
        System.out.println("Acelerando... Velocidade atual: " + velocidade + " km por hora.");       
    }
    
    public void parar(){
        velocidade = (int) (Math.random() * 5);
        System.out.println("Parando... Velocidade atual: " + velocidade + " km por hora.");         
    }
    
    public void parado(){
        velocidade = 0;
        System.out.println("Parado... Velocidade atual: " + velocidade + " km por hora.");         
    }
    
}
