public class Teste {
	public static void main(String[] args) {
		String s1 = "Matheus";
		String s2 = "Matheus";

		System.out.println(s1 == s2); // true
		System.out.println(s1.equals(s2)); // true

		String nome1 = new String("Matheus");
		String nome2 = new String("Matheus");

		System.out.println(nome1 == nome2); // false
		System.out.println(nome1.equals(nome2)); // true

		String nome3 = nome1.toUpperCase();
		System.out.println(nome1);
		System.out.println(nome3);
	}

}
