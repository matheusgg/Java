package test;

import proxy.HyperMock;

public class ProxyMain {

	public static void main(String[] args) {
		App appMock = HyperMock.mock(App.class);
		HyperMock.when(appMock.getMessage()).thenReturn("Teste");
		System.out.println(appMock.getMessage());

		HyperMock.when(appMock.getMessage2()).thenReturn("Teste 2");
		System.out.println(appMock.getMessage2());

		System.out.println(appMock.getMessage2());
		System.out.println(appMock.getMessage());
	}

}
