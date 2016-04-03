package javaapplication63;

import java.util.Calendar;

public class JavaApplication63 {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        long milisec = c.getTimeInMillis();
        String d = String.format("%tA, %<td de %<tB de 2011.", c.getTime());        
        System.out.println(d);        
        
        
        Calendar cal = Calendar.getInstance();
        cal.set(1993, 0, 10, 21, 15);
        long mili = cal.getTimeInMillis();
        System.out.println("\n" + cal.getTime());
        
        String milisecs_de_vida = String.format("%,d", (milisec - mili));
        System.out.println("\n" + milisecs_de_vida + " milisegundos de vida.");
    }
}
