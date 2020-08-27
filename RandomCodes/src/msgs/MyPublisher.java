package msgs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

public class MyPublisher {
    public static void main(String[] args) {
        try {
            InitialContext ctx = new InitialContext();
            TopicConnectionFactory f = (TopicConnectionFactory) ctx.lookup("topicFactory");
            TopicConnection con = f.createTopicConnection();
            con.start();

            TopicSession ses = con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic t = (Topic) ctx.lookup("myTopics");
            TopicPublisher publisher = ses.createPublisher(t);
            TextMessage msg = ses.createTextMessage();

            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Enter Msg, end to terminate:");
                String s = b.readLine();
                if (s.equals("end"))
                    break;
                msg.setText(s);

                publisher.publish(msg);
                System.out.println("Message successfully sent.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
