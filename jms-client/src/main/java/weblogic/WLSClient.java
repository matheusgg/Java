package weblogic;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Cliente JMS para consumir uma fila remota no Weblogic 12c. Nesta versão, é
 * necessário apenas importar o wlthint3client.jar para o classpath da
 * aplicação.
 * 
 * @see https://redstack.wordpress.com/2009/12/21/a-simple-jms-client-for-
 *      weblogic-11g/
 * 
 * @see http://zengjianbing.blogspot.com.br/2010/03/simple-weblogic-jms-client-
 *      code.html
 * 
 * @author matheus.goes
 *
 */
public class WLSClient {

	private static final String DEFAULT_CONNECTION_FACTORY = "<connection factory>";
	private static final String DEFAULT_DESTINATION = "<destination>";
	private static final String INITIAL_CONTEXT_FACTORY = "weblogic.jndi.WLInitialContextFactory";
	private static final String PROVIDER_URL = "t3://<host>:<port>";
	private static final String SECURITY_PRINCIPAL = "<username>";
	private static final String SECURITY_CREDENTIALS = "<password>";

	public static void main(String[] args) {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		env.put(Context.PROVIDER_URL, PROVIDER_URL);
		env.put(Context.SECURITY_PRINCIPAL, SECURITY_PRINCIPAL);
		env.put(Context.SECURITY_CREDENTIALS, SECURITY_CREDENTIALS);

		Context context = null;
		Connection connection = null;

		try {

			context = new InitialContext(env);
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
			Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// MessageProducer producer = session.createProducer(destination);
			// Message message = session.createTextMessage("Mensagem de Teste");
			// producer.send(message);

			/*
			 * Para consumir mensagens de uma fila é preciso iniciar a conexão.
			 */
			connection.start();

			MessageConsumer consumer = session.createConsumer(destination);
			Message message = consumer.receive();
			System.out.println(message.getBody(Object.class));

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			closeJMSResources(context, connection);
		}

	}

	private static final void closeJMSResources(Context context, Connection connection) {
		try {
			if (context != null) {
				context.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
