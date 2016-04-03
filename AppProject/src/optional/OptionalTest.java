package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		List<Matricula> matriculas = Arrays.asList(new Matricula(), new Matricula(), new Matricula());
		matriculas.stream().filter((m) -> m.getNumero().isPresent()).forEach((m -> System.out.println(m.getNumero())));
	}
}

class Matricula {

	private Optional<String> numero = Optional.of("123456");

	// private Optional<String> numero = Optional.empty();

	/**
	 * @return the numero
	 */
	public Optional<String> getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(Optional<String> numero) {
		this.numero = numero;
	}
}
