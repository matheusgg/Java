package calculadora;

/**
 * JNI
 * 
 * @author Matheus
 *
 */
public class Calculadora {

	static {
		System.load("/Users/Matheus/Documents/workspace/NativeProject/native/libcalculadora.dylib");
	}

	public native int soma(int num1, int num2);

}
