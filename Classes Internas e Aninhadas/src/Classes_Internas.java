public class Classes_Internas {
    
    public static void main(String[] args) {       
        Test.Test_Class ts = new Test.Test_Class(); // Classes internas estáticas não precisam de uma referência da classe interna
        ts.go();
        
        
        Test t = new Test();
        Test.Test_Class2 ts2 = t.new Test_Class2(); // Já classes internas não estáticas precisam de uma referência da classe encapsuladora
        ts2.go();
    }
}


/********************* Classes Internas *******************************/
class Test{
    private int x = 10;
    
    /************************ AS CLASSES ESTÁTICAS DENTRO DE OUTRA CLASSE SÃO CHAMADAS DE CLASSES ANINHADAS *************************************/
    static class Test_Class{ // Classes internas podem ser estáticas!!!
        public void go(){
            //int y = x; // As classes internas estáticas podem somente utilizar variáveis de instância e métodos estáticos
            System.out.println("Funcionou!!!");
        }    
    }
    
    /************************ AS CLASSES NÃO-ESTÁTICAS DENTRO DE OUTRA CLASSE SÃO CHAMADAS DE CLASSES INTERNAS *************************************/
    class Test_Class2{ // Classes internas podem ser estáticas!!!
        public void go(){
            int y = x;
            System.out.println("Funcionou!!!... 2");
        }    
    }
}
