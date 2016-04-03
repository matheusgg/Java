abstract class Animal{
	public Animal(int size){
		System.out.println("Eu sou a classe Animal e meu tamanho é " + size);
	}

	public void comer(){
		System.out.println("O animal está comento...");
	}

	public void faz_barulho(String porte){
		if(porte.equals("pequeno")){
			System.out.println("O animal está fazendo um barulho pequeno.");
		}
		if(porte.equals("medio")){
			System.out.println("O animal está fazendo um barulho mediano.");
		}
		if(porte.equals("grande")){
			System.out.println("O animal está fazendo um barulho grande.");
		}
	}
}

interface Pet{
	public abstract void brincar();
}

class Dog extends Animal implements Pet{
	public Dog(){
		this(25);
		System.out.println("Isso deve aparecer por último");
	}
	public Dog(int size){
		super(size);
		System.out.println("Eu sou o construtor sobrecarregado da classe Dog");
	}

	public void brincar(){
		System.out.println("O cachorro está brincando");
	}
}

final class Cat extends Dog implements Pet{
	public Cat(){
		System.out.println("Eu sou o construtor da classe Cat");
	}

	public void comer(){
		super.comer();
		System.out.println("O gatinho está comendo");
	}

	public void brincar(){
		System.out.println("O gatinho está brincando");
	}
}

public abstract class Mamiferos{
	public static void main(String[] args){
		Dog d = new Dog();
		d.comer();
		d.brincar();
		d.faz_barulho("medio");

		Cat c = new Cat();
		c.comer();
		c.brincar();
		c.faz_barulho("pequeno");               
	}
}
			

	