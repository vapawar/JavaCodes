package beansXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppHome
{

    public static void main(String[] args)
    {

	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	MessagerCodes mCodes = (MessagerCodes) context.getBean("MessagerCodes");

	mCodes.setMessage("Hey there.");
	System.out.println(mCodes.getMessage());
    }

}
