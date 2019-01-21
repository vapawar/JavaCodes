package vpz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppHome 
{
	public static void main(String []args)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		
		DemoCode wc=(DemoCode)context.getBean("workerBean");
		
		wc.getMessage();
		wc.setMessage("Hello vp");
		wc.getMessage();
	}
}
