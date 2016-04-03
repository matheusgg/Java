public class Heranca_exemplo {

    public static void main(String[] args) {
        /**************** Cachorro *****************/
        Cachorro dog = new Cachorro();
        String raca_dog = dog.mostrar_raca("Puddle");
        System.out.println("Cachorro da raça: " + raca_dog);
        dog.faz_barulho(dog.porte_animal);
        dog.comer();
        
        /**************** Rato *****************/
        Rato mouse = new Rato();
        String raca_mouse = mouse.mostrar_raca(null);
        System.out.println("Rato da raça: " + raca_mouse);
        mouse.faz_barulho(mouse.porte_animal);
        mouse.comer();
        
        /**************** Elefante *****************/
        Elefante elephant = new Elefante();
        String raca_ele = elephant.mostrar_raca(null);
        System.out.println("Elefante da raça: " + raca_ele);
        elephant.faz_barulho(elephant.porte_animal);
        elephant.comer();      
    }
}

class Animal{
    private String raça;
    String teste;
    
    public void faz_barulho(String porte_animal){
        if (porte_animal.equals("grande")) {
            System.out.println("Muito barulho!!!");            
        }
        
        if (porte_animal.equals("medio")) {
            System.out.println("Barulho mediano.");             
        }
        
        if (porte_animal.equals("pequeno")) {
            System.out.println("Barulho que quase ninguém escuta.");            
        }        
    }
    
    public void comer(){
        System.out.println("O animal está comendo...\n");        
    }
    
    public String mostrar_raca(String raca_animal){
        if (raca_animal == null) {
            String tipo = "Raça não especificada!";    
            raça = tipo;
            return raça;
        }else{
            raça = raca_animal;
            return raça;            
        }       
    }     
}


class Cachorro extends Animal{
    String porte_animal = "medio";
}

class Rato extends Animal{
    String porte_animal = "pequeno";     
}

class Elefante extends Animal{
    String porte_animal = "grande";
}
