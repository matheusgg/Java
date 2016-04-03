class Dog{
	String name;
		public static void main(String[] args){
			// cria um objeto Dog e o acessa
			Dog dog1 = new Dog();
			dog1.bark();
			dog1.name = "Bart";
			// agora cria uma matriz Dog
			Dog[] myDogs = new Dog[3];
			// e coloca algums Dogs nela
			myDogs[0] = new Dog();
			myDogs[1] = new Dog();
			myDogs[2] = dog1;
			// agora acessa os objetos Dog
			// usando as referências da matriz
			myDogs[0].name = "Fred";
			myDogs[1].name = "Marge";
			
			System.out.print("O nome do último cão é ");
			System.out.println(myDogs[2].name);
			// agora executa um loop pela matriz
			// e pede a todos os cães para latirem
			int x = 0;
			while(x < myDogs.length){
				myDogs[x].bark();
				x++;
			}
		}
		public void bark(){
			System.out.println(name + " diz Ruff!");
		}
		public void eat(){	}
		public void chaseCat(){	}
	}
		
		
		
		
		
		
		
		
			