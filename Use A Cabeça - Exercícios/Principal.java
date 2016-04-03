import java.io.*;
import java.util.*;

class Clothes{
	public void jeans() throws IOException{
		System.out.println("Este m�todo jeans lancar� uma exce��o");
		throw new IOException();
	}
	
	public void shirt() throws EmptyStackException{
		System.out.println("Este m�todo shirt lancar� uma exce��o");
		throw new EmptyStackException();
	}
}

public class Principal{
	public static void main(String[] args){
		Clothes c = new Clothes();
		
		try{
			System.out.println("Este � o primeiro comando de try");
			c.jeans();
		} catch (IOException ex){
			System.out.println("O m�todo jeans lan�ou uma exce��o");
		} finally {
			System.out.println("Este comando est� dentro de finally");
			try{
				System.out.println("O m�todo shirt � chamado");
				c.shirt();
			} catch(EmptyStackException eex){
				System.out.println("O m�todo shirt lan�ou uma exce��o");
			}
		}
		System.out.println("\nFim.");
	}
}
		
			