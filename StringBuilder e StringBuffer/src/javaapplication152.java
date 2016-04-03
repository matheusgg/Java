public class javaapplication152 {
    
    public static void main(String[] args) {
         /************************ STRING BUILDER ***************************/
        StringBuilder sb = new StringBuilder("spring"); // Cria um novo objeto StringBuilder "spring"
        sb.delete(3, 6); //deleta os valores a partir da posição 3 até 6, ou seja, deleta "ing"
        sb.insert(2, "umme"); //insere "umme" na posição 2, ficando "spummer"
        sb.deleteCharAt(1); //deleta o valor da posição 1, ficando "summer"
        System.out.println(sb);
        
        
        
        StringBuilder sb2 = new StringBuilder("macacos");
        sb2.delete(2, 4); 
        sb2.insert(2, "theu"); 
        sb2.deleteCharAt(6); 
        sb2.deleteCharAt(6);
        sb2.append(" Gomes");
        System.out.println(sb2);
        
        
        
         /************************ STRING BUFFER ***************************/
        StringBuffer s_b = new StringBuffer("spring"); // Cria um novo objeto StringBuffer "spring"
        s_b.delete(3, 6); //deleta os valores a partir da posição 3 até 6, ou seja, deleta "ing"
        s_b.insert(2, "umme"); //insere "umme" na posição 2, ficando "spummer"
        s_b.deleteCharAt(1); //deleta o valor da posição 1, ficando "summer"
        System.out.println(s_b);
        
        
        
        StringBuffer s_b2 = new StringBuffer("macacos");
        s_b2.delete(2, 4); 
        s_b2.insert(2, "theu"); 
        s_b2.deleteCharAt(6); 
        s_b2.deleteCharAt(6);
        s_b2.append(" Gomes");
        System.out.println(s_b2);
        
        
        // OBS.: Tanto StringBuffer quanto StringBuilder funcionam da mesma forma, a única diferença é que StringBuffer é a prova de segmentos, mas isso geralmente não é necessário, então deve-se utilizar StringBuilder
    }
}
