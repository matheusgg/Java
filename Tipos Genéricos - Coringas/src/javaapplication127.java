import java.util.*;

public class javaapplication127 {

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Matheus");
        lista.add("Rose");
        lista.add("Nelson");
        
        go(lista);
        
        System.out.println("\n\n");
        
        go2(lista);       
    }
    
    
    /************************* ESSES DOIS MÉTODOS FAZEM A MESMA COISA ************************************/
    public static <T extends String> void go(ArrayList<T> list){
        System.out.println(list);
    }
    
    public static void go2(ArrayList<? extends String> list){ // A diferença é que esse método utiliza uma sintaxe diferente <? extends String>
        System.out.println(list);
    }
    /*************************** ESSAS SINTAXES SÃO CHAMADAS DE CORINGA ************************************/
    /******************************************************************************************************/
}
