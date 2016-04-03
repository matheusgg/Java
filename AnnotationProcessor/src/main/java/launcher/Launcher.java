package launcher;

import processor.annotation.Invoke;

public class Launcher {

	public static void main(String[] args) {
		System.out.println("App.main()");
	}
}

@Invoke("metodoDeTeste")
class Teste {

	public void teste() {

	}

	public void metodoDeTeste() {

	}

}
