package msgs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class MyProducer {
    public static void main(String[] args) {
        try {
            InitialContext ctx = new InitialContext();
            QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("queueFactory");
            QueueConnection con = f.createQueueConnection();
            con.start();

            QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue t = (Queue) ctx.lookup("myQueue");
            QueueSender sender = ses.createSender(t);
            TextMessage msg = ses.createTextMessage();

            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Enter Msg, end to terminate:");
                String s = b.readLine();
                if (s.equals("end"))
                    break;
                msg.setText(s);

                sender.send(msg);
                System.out.println("Message successfully sent.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}