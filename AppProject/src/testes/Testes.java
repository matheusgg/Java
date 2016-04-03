package testes;

import java.util.function.Function;

public class Testes {

	public static void main(String[] args) {
		Function<Integer, Integer> f = Integer::new;
		System.out.println(f.apply(10));
	}

}
