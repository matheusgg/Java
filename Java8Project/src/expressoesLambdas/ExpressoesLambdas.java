package expressoesLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Expressoes lambdas é uma forma simples de implementar um método de uma
 * interface funcional sem ter que implementá-la ou criar uma classe anonima.
 * Com as expressoes lambda, uma instancia de uma interface funcional é
 * retornada. A implementacao do metodo dessa interface é o corpo da expressao
 * lambda. O compilador consegue inferir sobre a interface funcional verificando
 * o "tipo alvo", ou seja, de acordo com o contexto da expressao lambda, o
 * compilador consegue identificar o tipo da interface funcional que representa
 * aquela expressao lambda.
 * 
 * @author Matheus
 *
 */
public class ExpressoesLambdas {

	// private static String variavelEstaticaParauUtilizacaoLambdas = "Teste";

	public static void main(String[] args) throws Exception {
		/*
		 * Quando o metodo da interface funcional nao possuir parametros, ()
		 * deve ser especificada.
		 */
		// MyFunctionalInterface inter1 = () -> System.out.println("Teste");
		// inter1.metodo();

		// =======================================================================================

		/*
		 * QUando o método possui um retorno, o corpo da expressao lamda deve
		 * resultar em um retorno válido para aquele método. Caso dentro do
		 * corpo da lambda seja especificada apenas uma expressao, esta será
		 * utilizada como retorno do metodo, caso contrário, um return explicito
		 * deve ser informado.
		 */
		// MyFunctionalInterface2 inter2 = () -> "Matheus";
		// System.out.println(inter2.metodo2());

		// inter2 = () -> {
		// System.out.println("Teste de retorno em expressoes lambdas");
		// return "Matheus";
		// };
		// System.out.println(inter2.metodo2());

		// =======================================================================================

		/*
		 * Quando o metodo recebe apenas um parametro, o tipo nao precisa ser
		 * especificado. Alem disso, os () sao opcionais.
		 */
		// MyFunctionalInterface3 inter3 = parametro ->
		// System.out.println(parametro);
		// inter3.metodo2("Teste");

		// inter3 = (parametro) -> System.out.println(parametro);
		// inter3.metodo2("Parametro");

		// inter3 = (String param) -> System.out.println(param);
		// inter3.metodo2("Parametro String");

		// =======================================================================================

		/*
		 * Uma expressao lambda pode ser aplicada em qualquer lugar onde o tipo
		 * alvo seja identificavel, inclusive um cast.
		 */
		// Object obj = (MyFunctionalInterface) () ->
		// System.out.println("Teste");
		// System.out.println(obj);

		// =======================================================================================

		/*
		 * Quando o metodo recebe mais de um parametro, basta utilizar , para
		 * separa-los.
		 */
		// Inter1 i1 = (String firts, String last) -> "Olá " + firts + " " +
		// last;
		// System.out.println(i1.hello("Matheus", "Gomes"));

		// =======================================================================================

		/*
		 * Uma expressao lambda nao declara um novo escopo, mas sim um contexto
		 * estatico, deste modo, nao é possível utilizar as
		 * referencias super ou this. Além disso, variaveis de referencia da
		 * classe encapsuladora so poderao ser acessadas dentro da expressao
		 * lambda se forem declaradas como static. Dentro de uma expressao
		 * lambda, é possível acessar variaveis do metodo encapsulador, porém
		 * não é possível redefinir o seu valor.
		 */
		// int x = 10;
		// MyFunctionalInterface i2 = () -> {
		// // x = 20; Erro de compilacao.
		// System.out.println(x);
		// System.out.println(ExpressoesLambdas.variavelEstaticaParauUtilizacaoLambdas);
		// };
		// i2.metodo();

		// =======================================================================================
		/*
		 * Expressoes lambdas podem apenas lancar as excecoes declaradas no
		 * metodo da interface funcional, ou subclasses dessas excecoes.
		 */
		// Inter2 i2 = (b) -> {
		// if (b) {
		// // throw new IllegalBlockSizeException(""); Nao compila
		// } else {
		// throw new IllegalAccessException("");
		// }
		// };

		// =======================================================================================

		/*
		 * Essa expressao lambda declara um varargs de int, enquanto a interface
		 * funcional declara um metodo que recebe um array de int (int[]). Com
		 * as expressoes lambdas, isso nao faz diferenca nenhuma, ou seja, é
		 * permitido declarar um vararg quando o metodo declara um array.
		 */
		// Inter3 i3 = (int... i) -> System.out.println("Teste");

		// =======================================================================================

		/*
		 * Erro de compilacao, pois ja que nao foi especificado um tipo
		 * parametrizado para Inter4, o tipo da variavel do metodo da interface
		 * funcional é Object, como o tipo Integer está sendo informado, o
		 * compilador gerara um erro em tempo de compilacao.
		 */
		// Inter4 i4 = (Integer i) -> System.out.println(i + 10);

		// =======================================================================================

		/*
		 * Expressoes lambdas podem ser aplicadas em retornos quando o tipo do
		 * retornor for uma interface funcional
		 */
		// ExpressoesLambdas.getRunnable().run();

		// =======================================================================================
		/*
		 * O tipo alvo de uma expressao lambda pode ser outra expressao lambda.
		 * Neste caso, a expressao mais interna retorna um Runnable, esse
		 * Runnable é retornado do metodo call, que de acordo com o contexto
		 * (Callable<Runnable>) retorna um Runnable;
		 */
		// Callable<Runnable> call = () -> () ->
		// System.out.println("Hello from Runnable");
		// Callable<Runnable> call = () -> {return () ->
		// System.out.println("Hello from Runnable");}; // isso é equivalente a
		// expressao acima
		// call.call().run();

		// =======================================================================================
		/*
		 * Existem casos onde o tipo alvo pode ser mais de um, neste caso, um
		 * cast deve ser feito para evitar um erro de compilacao
		 */
		// ExpressoesLambdas.testeAmbiguidade((MyFunctionalInterface) () ->
		// System.out.println("Teste de ambiguidade"));

		// =======================================================================================
		/*
		 * Expressoes lambdas podem ser utilizadas em condicoes ternarias
		 */
		// Runnable r = (Math.random() * 100) > 50 ? () ->
		// System.out.println("True") : () -> System.out.println("False");
		// r.run();

		// =======================================================================================
		/*
		 * Novas variaveis sao criadas quando um expressao lambda declara um
		 * parametro, desta forma, caso uma variavel com o mesmo nove ja tenha
		 * sido declarada, um erro de compilacao ocorrera.
		 */
		// String param = "Teste";
		// MyFunctionalInterface3 i3 = (param) -> System.out.println(param);//
		// Erro de compilacao

		// =======================================================================================

		// ExpressoesLambdas.methodReference();

		// =======================================================================================

		// ExpressoesLambdas.constructorReference();
	}

	/**
	 * Referencia de construtores indica o objeto que deve ser retornado quando
	 * determinado metodo de uma interface funcional é chamado. Neste exemplo, a
	 * interface funcional Inter6 possui o metodo make que retorna uma lista
	 * (List<String>), desta forma, uma referencia de construtor pode ser
	 * utilizada para criar o objeto que será retornado na chamada ao metodo
	 * make.
	 */
	public static void constructorReference() {
		Inter6 i6 = ArrayList<String>::new;
		System.out.println(i6.make());
	}

	/**
	 * Referencias de métodos é uma simplificacao das expressoes lambdas. Neste
	 * caso, o metodo sort de Collections recebe uma lista e um objeto do tipo
	 * Comparator, como Comparator é uma interface funcional, uma expressao
	 * lambda pode ser aplicada. Deste modo, é possível passar uma referencia de
	 * metodo para comparar as Strings dessa lista. Uma referencia de método
	 * nada mais é do que o corpo (implementacao) do metodo da interface
	 * funcional que representa uma determinada expressao lambda. Sendo assim, o
	 * metodo compareTo das Strings passadas ao metodo compare de Comparator
	 * será chamado.
	 */
	public static void methodReference() {
		List<String> lista = Arrays.asList("Matheus", "Gomes", "Góes");

		/*
		 * Uma referencia de metodo pode ser um método estático, um método de um
		 * objeto qualquer ou um método de uma instancia de classe.
		 */
		Collections.sort(lista, ExpressoesLambdas::compare); // Metodo estatico
		Collections.sort(lista, String::compareTo); // Metodo da instancia que
													// representa a classe
													// String
		System.out.println(lista);

		// =======================================================================================

		Item i1 = new Item("Teste");
		List<Item> lista2 = Arrays.asList(i1, new Item("Matheus"), new Item("Gomes"));

		/*
		 * Isto funciona pois dentro do metodo compareTo(T o1, T o2) de
		 * Comparator, o método compare de o1 será chamado e recebera como
		 * argumento o objeto o2, ficando o1.compare(o2). Por este motivo, mesmo
		 * o método compare de Item nao ser estatico, ele pode ser utilizado
		 * aqui, pois apenas informa para a JVM qual metodo devera ser chamado.
		 */
		Collections.sort(lista2, Item::compare);

		/*
		 * Aqui, compare2 possui a mesma assinatuda de compare em Comparator
		 * (compare2(Item, Item) = compare(T, T)), desta forma, o metodo
		 * compare2 do objeto i1 será chamado dentro de compare para comparar os
		 * dois objetos recebidos.
		 */
		// Collections.sort(lista2, i1::compare2);

		System.out.println(lista2);
	}

	public static int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

	public static void testeAmbiguidade(MyFunctionalInterface f1) {
		f1.metodo();
	}

	public static void testeAmbiguidade(MyFunctionalInterface4 f4) {
		f4.metodo();
	}

	public static Runnable getRunnable() {
		return () -> System.out.println("Teste");
	}

}

class Item implements Inter5 {

	private String nome;

	public Item(String nome) {
		this.nome = nome;
	}

	@Override
	public int compare(Inter5 i5) {
		return this.nome.compareTo(((Item) i5).nome);
	}

	public int compare2(Item i1, Item i2) {
		System.out.println(this.nome);
		return i1.compare(i2);
	}

	@Override
	public String toString() {
		return this.nome;
	}
}

@FunctionalInterface
interface Inter6 {

	List<String> make();
}

@FunctionalInterface
interface Inter5 {

	int compare(Inter5 i5);
}

@FunctionalInterface
interface Inter4<T> {

	void test(T i);
}

@FunctionalInterface
interface Inter3 {

	void test(int[] i);
}

@FunctionalInterface
interface Inter2 {

	void test(boolean b) throws IllegalAccessException;
}

@FunctionalInterface
interface Inter1 {

	String hello(String firtsName, String lastName);
}

/**
 * Uma interface funcional é uma interface que possui apenas um método abstrato;
 * 
 * @author Matheus
 *
 */
@FunctionalInterface
interface MyFunctionalInterface {

	void metodo();

}

@FunctionalInterface
interface MyFunctionalInterface2 {

	String metodo2();

}

@FunctionalInterface
interface MyFunctionalInterface3 {

	void metodo2(String param);

}

@FunctionalInterface
interface MyFunctionalInterface4 {

	void metodo();

}
