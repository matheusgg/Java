package defaults;

public interface Inter2 extends Inter1 {
	
	@Override
	public default void metodo1() {
		System.out.println("Inter2.metodo1()");
	}

}
