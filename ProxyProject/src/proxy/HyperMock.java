package proxy;

import java.lang.reflect.Proxy;

public final class HyperMock {

	private static Object lastSpy;

	@SuppressWarnings("unchecked")
	public static <T> T mock(Class<T> interfaceToSpy) {
		lastSpy = Proxy.newProxyInstance(HyperMock.class.getClassLoader(), new Class<?>[] { interfaceToSpy }, new HyperMockInvocationHandler());
		return (T) lastSpy;
	}

	public static HyperMockInvocationHandler when(Object method) {
		return (HyperMockInvocationHandler) Proxy.getInvocationHandler(lastSpy);
	}

}
