package reflection;

import java.lang.reflect.ParameterizedType;

public class GenericType extends SuperClasse<Long> {

	public GenericType() {
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<?> clazz = (Class<?>) parameterizedType.getActualTypeArguments()[0];
		System.out.println(clazz);
	}

	public static void main(String[] args) {
		new GenericType();
	}

}

class SuperClasse<T> {

}
