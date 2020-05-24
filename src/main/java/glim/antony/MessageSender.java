package glim.antony;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.logging.Logger;

public class MessageSender {

    private static final Logger log = Logger.getLogger(MessageSender.class.getName());

    private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL; // default broker URL is : tcp://localhost:61616"
    private static final String JMS_QUEUE_NAME = "MyJmsQueueName";

    public static void send(String message) throws JMSException {

        Connection connection = new ActiveMQConnectionFactory(URL).createConnection();
        connection.start();

        //Creating a non transactional session to send/receive JMS message.
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(JMS_QUEUE_NAME);
        MessageProducer producer = session.createProducer(destination);
        TextMessage textMessage = session.createTextMessage(message);

        producer.send(textMessage);

        log.info("message were send: " + textMessage.getText());
        connection.close();
    }
}
