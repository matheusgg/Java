package agent;

import java.lang.instrument.Instrumentation;

/**
 * JavaAgents são componentes que adicionam a capacidade de instrumentação para
 * aplicações. Instrumentação, por sua vez, nada mais é do a redefinição do
 * conteúdo de uma classe em tempo de execução. Para criar um agente é preciso
 * declarar o método: <br>
 * <b> <code>public static void premain(String agentArgument,
 * Instrumentation instrumentation)</code></b><br>
 * Como agentes Java nada mais são do que arquivos jars, é necessário criar um
 * arquivo jar com um <b>/META-INF/MANIFEST.MF</b> que possua a entrada
 * <b>Premain-Class=nome completo da classe agente que possui o método
 * premain</b>.
 * 
 * @author mggoes
 *
 */
public class SimpleJavaAgent {

	public static void premain(String agentArgument, Instrumentation instrumentation) {
		System.out.println("Starting agent...");
		instrumentation.addTransformer(new SimpleTransformer());
	}

}
