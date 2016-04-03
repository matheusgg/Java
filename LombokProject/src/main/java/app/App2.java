package app;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class App2 {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		// List<Cliente> clientes = new ArrayList<Cliente>();
		//
		// Cliente cliente = null;
		// for (int i = 0; i < 10; i++) {
		// cliente = new Cliente();
		// cliente.setAtivo(i < 5 ? true : false);
		// cliente.setId((long) (i + 1));
		// cliente.setCpf(i * 14);
		// cliente.setNascimento(LocalDate.of(1990, i + 1, (i + 1) * 2));
		// cliente.setNome("Cliente " + (i + 1));
		// cliente.setTelefone("5677736" + i);
		// clientes.add(cliente);
		// }
		//
		// clientes.removeIf((c) -> c.isAtivo());
		// System.out.println("Clientes Inativos: " + clientes.size());
		// clientes.forEach((c) -> System.out.println(c.getNome()));

		// ==============================================================================

		// Path documents = Paths.get("/Users/Matheus/Documents");
		// Files.walk(documents).filter(p ->
		// "TCC - Entrega TC-1 - V7.docx".equals(p.getFileName().toString())).forEach(p
		// -> System.out.println(p));

		// ==============================================================================
		// SecureRandom.getInstanceStrong().ints(2).forEach(i ->
		// System.out.print(Math.abs(i)));

		// ==============================================================================
		// LocalDate nascimento = LocalDate.of(1993, 01, 10);
		// System.out.println(nascimento.until(LocalDate.now(),
		// ChronoUnit.YEARS));
	}
}
