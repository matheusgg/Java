package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HyperMockInvocationHandler implements InvocationHandler {

	private Method lastCalledMethod;
	private Map<Method, Object> mapping;

	public HyperMockInvocationHandler() {
		this.mapping = new HashMap<>();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.lastCalledMethod = method;
		return this.mapping.get(this.lastCalledMethod);
	}

	public <T> void thenReturn(T valueToReturn) {
		this.mapping.put(this.lastCalledMethod, valueToReturn);
	}

}
