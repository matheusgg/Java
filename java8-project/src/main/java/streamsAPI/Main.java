package streamsAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Um Stream é um fluxo de elementos que suporta operações agregadas.
 * 
 * @author mggoes
 *
 */
public class Main {

	public static void main(String[] args) {
		/*
		 * Filter
		 */
		List<Order> orders = Arrays.asList(new Order(1, 99.6), new Order(2, 18.2), new Order(3, 56.4), new Order(4, 71.86));
		System.out.println(orders.stream().filter(o -> o.getValue() > 60).count());

		/*
		 * Sorted
		 */
		System.out.println("==============================================================================================");
		orders.stream().sorted((order1, order2) -> Double.compare(order1.getValue(), order2.getValue())).forEach(System.out::println);

		/*
		 * Map
		 */
		System.out.println("==============================================================================================");
		System.out.println(orders.stream().mapToDouble(Order::getValue).sum());

		/*
		 * Joining
		 */
		System.out.println("==============================================================================================");
		List<String> words = Arrays.asList("Java 8", "JSF", "CDI", "JMS", "EJB", "JSON-P", "JAX-RS", "JAX-WS", "WebSockets");
		System.out.println(words.stream().collect(Collectors.joining(", ")));

	}

}
