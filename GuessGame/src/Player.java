import java.util.Scanner;
public class Player {    
    int number = 0;
    
    public void guess(){
        Scanner sc;
        sc = new Scanner(System.in);               
        number = sc.nextInt();//(int) (Math.random() * 10);
        System.out.println("Estou pensando em " + number);        
    }    
}
