package interfacesComEnums;

/**
 * Desde o Java 5 é possível implementar interfaces em Enums.
 * 
 * @author Matheus
 *
 */
public class InterfacesComEnums {

	public static void main(String[] args) {
		InterfacesComEnums.metodo(Enumarador.TESTE);
	}

	public static void metodo(Enums enums) {
		System.out.println(enums);
	}
}

interface Enums {

}

enum Enumarador implements Enums {
	TESTE
}
