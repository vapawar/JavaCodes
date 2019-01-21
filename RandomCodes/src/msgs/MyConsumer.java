package msgs;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;

public class MyConsumer
{
	public static void main(String[] args)
	{
		try
		{

			InitialContext ctx = new InitialContext();
			QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("queueFactory");
			QueueConnection con = f.createQueueConnection();
			con.start();

			QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue t = (Queue) ctx.lookup("myQueue");
			QueueReceiver receiver = ses.createReceiver(t);
			MyListener listener = new MyListener();
			receiver.setMessageListener(listener);

			System.out.println("Receiver1 is ready, waiting for messages...");
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