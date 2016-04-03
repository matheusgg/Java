public class TestaFuncionario {
	public static void main(String[] args) {
		Gerente g = new Gerente();
		g.setSalario(5000);
		g.setNome("Gerente");
		g.setSenha("123");
		g.setUsuario("user");

		Secretaria s = new Secretaria();
		s.setNome("Secretária");
		s.setRamal(25);
		s.setSalario(1200);

		Telefonista t = new Telefonista();
		t.setEstacaoDeTrabalho(53);
		t.setNome("Telefonista");
		t.setSalario(1100);

		g.mostraDados();
		s.mostraDados();
		t.mostraDados();
	}
}
