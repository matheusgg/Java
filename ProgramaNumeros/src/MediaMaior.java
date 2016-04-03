/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Matheus
 */
public class MediaMaior {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lervalor = new Scanner(System.in);
        int vetor[] = new int[10];
        int maior = 0, media, soma = 0;
        
        for (int i = 0; i < 10; i++) {
            
            System.out.println("Digite o " + (i + 1) + "º número: ");
            vetor[i] = lervalor.nextInt();
            soma += vetor[i];
            
            if (vetor[i] > maior) {
                
                maior = vetor[i];                
            }            
        }
        media = soma/10;
        
        System.out.println("A média dos números é: " + media);
        System.out.println("O maior valor é: " + maior);
        
    }
}
