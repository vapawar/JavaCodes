package apachemq;

import java.io.IOException;
import java.sql.Connection;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.print.attribute.standard.Destination;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageConsumerAMQ {
    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("messagesQueue");
        MessageConsumer consumer = session.createConsumer(destination);
        TextMessage message = (TextMessage) consumer.receive();
        System.out.println(message.getText());
        while ((message = (TextMessage) consumer.receive()) != null) {
            message = (TextMessage) consumer.receive();
            System.out.println(message.getText());
        }
        connection.close();
    }
}