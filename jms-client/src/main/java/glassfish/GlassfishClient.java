package glassfish;

/**
 * Cliente JMS para consumir uma fila remota no Glassfish 4. É necessário apenas
 * importar o jar gf-client.jar para o classpath da aplicação, porém para o
 * cliente funcionar, é preciso que o jar seja importado diretamente do
 * diretorio onde ele está localizado dentro do servidor do glassfish, pois o
 * mesmo faz referencias a varios outros jars do diretorio de instalação do
 * servidor.
 * 
 * @see http://techtipsjava.blogspot.com.br/2013/05/jms-on-glassfish-queue-and-
 *      topic-with.html?m=1
 * 
 * @see http://stackoverflow.com/questions/2087938/glassfish-v3-jndi-entry-
 *      cannot-be-found-problems
 * 
 * @author matheus.goes
 *
 */
public class GlassfishClient {

//	private static final String DEFAULT_MESSAGE = "Mensagem de Teste";
//	private static final String DEFAULT_CONNECTION_FACTORY = "jms/__defaultConnectionFactory";
//	private static final String DEFAULT_DESTINATION = "jms/queue/DefaultQueue";
//	private static final String INITIAL_CONTEXT_FACTORY = "com.sun.enterprise.naming.impl.SerialInitContextFactory";
//	private static final String PROVIDER_URL = "mq://localhost:7676";
//
//	public static void main(String[] args) {
//		Properties env = new Properties();
//		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
//		env.put(Context.PROVIDER_URL, PROVIDER_URL);
//
//		Context context = null;
//		Connection connection = null;
//
//		try {
//
//			context = new InitialContext(env);
//			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
//			Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);
//			connection = connectionFactory.createConnection();
//			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//
//			MessageProducer producer = session.createProducer(destination);
//			producer.send(session.createTextMessage(DEFAULT_MESSAGE));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			closeJMSResources(context, connection);
//		}
//
//	}
//
//	private static final void closeJMSResources(Context context, Connection connection) {
//		try {
//			if (context != null) {
//				context.close();
//			}
//
//			if (connection != null) {
//				connection.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
