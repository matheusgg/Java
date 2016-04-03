package wildfly;

/**
 * Cliente JMS para consumir uma fila remota no Wildfly 9. É necessário que a
 * connection factory e a fila estejam configuradas com um JNDI exportavel no
 * standalone.xml (prefixo java:jboss/exported), além de deninir a configuração
 * security-enabled para false:<br>
 * 
 * <subsystem xmlns="urn:jboss:domain:messaging:3.0"> <hornetq-server>
 * <security-enabled>false</security-enabled>
 * <journal-file-size>102400</journal-file-size>
 * 
 * <connectors> <http-connector name="http-connector" socket-binding="http">
 * <param key="http-upgrade-endpoint" value="http-acceptor" /> </http-connector>
 * <in-vm-connector name="in-vm" server-id="0" /> </connectors>
 * 
 * <acceptors> <http-acceptor http-listener="default" name="http-acceptor" />
 * <in-vm-acceptor name="in-vm" server-id="0" /> </acceptors>
 * 
 * <jms-connection-factories> <connection-factory name=
 * "RemoteConnectionFactory"> <connectors> <connector-ref connector-name=
 * "http-connector" /> </connectors>
 * <entries> <entry name="java:jboss/exported/jms/RemoteConnectionFactory" />
 * </entries> </connection-factory>
 * 
 * <pooled-connection-factory name="hornetq-ra"> <transaction mode="xa" />
 * <connectors> <connector-ref connector-name="http-connector" /> </connectors>
 * <entries> <entry name="java:/JmsXA" /> <entry name=
 * "java:/DefaultJMSConnectionFactory" /> </entries>
 * </pooled-connection-factory> </jms-connection-factories>
 * 
 * <jms-destinations> <jms-queue name="DefaultQueue"> <entry name=
 * "java:/jms/queue/DefaultQueue" /> </jms-queue>
 * 
 * <jms-queue name="DefaultRemoteQueue"> <entry name=
 * "java:jboss/exported/jms/queue/DefaultRemoteQueue" /> </jms-queue>
 * </jms-destinations> </hornetq-server> </subsystem>
 * <hr>
 * 
 * É também preciso configurar o realm do http-connector para o realm que possua
 * usuários cadastrados: <br>
 * 
 * <subsystem xmlns="urn:jboss:domain:remoting:3.0"> <endpoint worker="default"
 * /> <http-connector name="http-remoting-connector" connector-ref="default"
 * security-realm="ManagementRealm" /> </subsystem> <br>
 * 
 * @see http://www.mastertheboss.com/jboss-server/jboss-jms/how-to-code-a-remote
 *      -jms-client-for-wildfly-8
 * 
 * @author matheus.goes
 *
 */
public final class WildflyClient {

//	private static final String DEFAULT_MESSAGE = "Mensagem de Teste";
//	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
//	private static final String DEFAULT_DESTINATION = "jms/queue/DefaultRemoteQueue";
//	private static final String DEFAULT_USERNAME = "<Username>";
//	private static final String DEFAULT_PASSWORD = "<Password>";
//	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
//	private static final String PROVIDER_URL = "http-remoting://localhost:8080";
//
//	public static void main(String[] args) {
//		Properties env = new Properties();
//		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
//		env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
//		env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", DEFAULT_USERNAME));
//		env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", DEFAULT_PASSWORD));
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
