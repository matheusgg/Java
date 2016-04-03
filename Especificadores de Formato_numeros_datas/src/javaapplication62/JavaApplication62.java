package javaapplication62;

import java.util.Date;

public class JavaApplication62 {

   public static void main(String[] args) {
       /***************************** NUMEROS ***********************************/
       String s = String.format("Tenho %,d de erros a corrigir %,.3f", 1000, 589685.253965); // Especificadores de formato: , => insere um ponto / d e f => são os tipos / .3 => precisão
       System.out.println(s);
       
       /***************************** DATAS ***********************************/
       Date today = new Date();
       String d = String.format("%tA, %<td de %<tB", today); // tA => Dia por extenso / td => dia abreviado (número) / tB => mês / "<" => utilizar o parâmetro anterior (evita repetir "today" três vezes)
       System.out.println(d);
       
       Date today_2 = new Date();
       String d_2 = String.format("%tc ____ %<tr", today_2); // tc => mostra data e hora / tr => mostra apenas a hora
       System.out.println(d_2);
       
    }
}
