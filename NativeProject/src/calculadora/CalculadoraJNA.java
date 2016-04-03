package calculadora;

import com.sun.jna.Library;

/**
 * JNA
 * 
 * @author Matheus
 *
 */
public interface CalculadoraJNA extends Library {

	int soma(int num1, int num2);

}
