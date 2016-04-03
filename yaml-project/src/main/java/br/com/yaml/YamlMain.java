package br.com.yaml;

import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import br.com.yaml.model.Cliente;

/**
 * YAML (YAML Ain`t Markup Language) é uma formato para serializacao de dados
 * criado para ser legivel para seres humanos e facil de ser lido por linguagens
 * de script.
 * 
 * @author Matheus
 *
 */
public class YamlMain {

	public static void main(String[] args) throws Exception {
		ClassLoader classLoader = YamlMain.class.getClassLoader();

		Yaml yaml = new Yaml();

		// Listas
		List<?> lista = (List<?>) yaml.load(classLoader.getResourceAsStream("test1.yml"));
		System.out.println(lista);

		// Mapa
		Map<?, ?> mapa = (Map<?, ?>) yaml.load(classLoader.getResourceAsStream("test2.yml"));
		System.out.println(mapa);

		// Documentos
		Iterable<Object> docs = yaml.loadAll(classLoader.getResourceAsStream("test3.yml"));
		for (Object doc : docs) {
			System.out.println(doc);
		}

		// Tipos Customizados
		TypeDescription typeDescription = new TypeDescription(Cliente.class);
		typeDescription.putListPropertyType("items", String.class);
		Constructor constructor = new Constructor(typeDescription);
		yaml = new Yaml(constructor);
		Cliente cliente = (Cliente) yaml.load(classLoader.getResourceAsStream("test4.yml"));
		System.out.println(cliente);

		// Ou
		cliente = yaml.loadAs(classLoader.getResourceAsStream("test4.yml"), Cliente.class);
		System.out.println(cliente);

		// Serializa um objeto para o formato YAML
		String yml = yaml.dump(cliente);
		System.out.println(yml);
		
		// Tags
		yaml = new Yaml();
		Map<?, ?> mapa2 = (Map<?, ?>) yaml.load(classLoader.getResourceAsStream("test5.yml"));
		System.out.println(mapa2);
	}

}
