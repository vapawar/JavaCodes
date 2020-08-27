package apachemq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.print.attribute.standard.Destination;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageProducerAMQ {

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);// ("http://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("messagesQueue");
        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage("Hello from apache activeMQ::::::");
        producer.send(message);

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter Msg, end to terminate:");
            String s = b.readLine();
            if (s.equals("end"))
                break;
            message = session.createTextMessage(s);
            producer.send(message);
            System.out.println("Message successfully sent.");
        }
        connection.close();
    }
}
