package msgs;

import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;

public class MySubscriber
{
	public static void main(String[] args)
	{
		try
		{

			InitialContext ctx = new InitialContext();
			TopicConnectionFactory f = (TopicConnectionFactory) ctx.lookup("topicFactory");
			TopicConnection con = f.createTopicConnection();
			con.start();

			TopicSession ses = con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			Topic t = (Topic) ctx.lookup("myTopics");
			TopicSubscriber receiver = ses.createSubscriber(t);
			MyListener listener = new MyListener();
			receiver.setMessageListener(listener);

			System.out.println("Subscriber1 is ready, waiting for messages...");
			System.out.println("press Ctrl+c to shutdown...");
			while (true)
			{
				Thread.sleep(1000);
			}
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

}
