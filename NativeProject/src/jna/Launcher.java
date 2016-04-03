package jna;

import calculadora.Calculadora;
import calculadora.CalculadoraJNA;

import com.sun.jna.Native;

public class Launcher {

	public static void main(String[] args) {
		/*
		 * gcc -o libcalculadora.dylib -shared -I/Users/Matheus/Downloads (pasta
		 * que contem os arquivos jni.h e jni_md.h) calculadora.c
		 */
		// Usando JNI
		Calculadora calc = new Calculadora();
		System.out.println(calc.soma(50, 20));

		/*
		 * gcc -o libcalculadoraJNA.dylib -shared calculadoraJNA.c
		 */
		// Usando JNA
		CalculadoraJNA calcJNA = (CalculadoraJNA) Native.loadLibrary("/Users/Matheus/Documents/workspace/NativeProject/native/libcalculadoraJNA.dylib",
				CalculadoraJNA.class);
		System.out.println(calcJNA.soma(100, 50));
	}

}
