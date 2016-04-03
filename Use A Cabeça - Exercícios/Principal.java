import java.io.*;
import java.util.*;

class Clothes{
	public void jeans() throws IOException{
		System.out.println("Este método jeans lancará uma exceção");
		throw new IOException();
	}
	
	public void shirt() throws EmptyStackException{
		System.out.println("Este método shirt lancará uma exceção");
		throw new EmptyStackException();
	}
}

public class Principal{
	public static void main(String[] args){
		Clothes c = new Clothes();
		
		try{
			System.out.println("Este é o primeiro comando de try");
			c.jeans();
		} catch (IOException ex){
			System.out.println("O método jeans lançou uma exceção");
		} finally {
			System.out.println("Este comando está dentro de finally");
			try{
				System.out.println("O método shirt é chamado");
				c.shirt();
			} catch(EmptyStackException eex){
				System.out.println("O método shirt lançou uma exceção");
			}
		}
		System.out.println("\nFim.");
	}
}
		
			