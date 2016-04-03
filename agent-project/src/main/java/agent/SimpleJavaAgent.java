package agent;

import java.lang.instrument.Instrumentation;

/**
 * JavaAgents s�o componentes que adicionam a capacidade de instrumenta��o para
 * aplica��es. Instrumenta��o, por sua vez, nada mais � do a redefini��o do
 * conte�do de uma classe em tempo de execu��o. Para criar um agente � preciso
 * declarar o m�todo: <br>
 * <b> <code>public static void premain(String agentArgument,
 * Instrumentation instrumentation)</code></b><br>
 * Como agentes Java nada mais s�o do que arquivos jars, � necess�rio criar um
 * arquivo jar com um <b>/META-INF/MANIFEST.MF</b> que possua a entrada
 * <b>Premain-Class=nome completo da classe agente que possui o m�todo
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
