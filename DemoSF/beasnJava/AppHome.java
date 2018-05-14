package beasnSF2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppHome 
{

	public static void main(String[] args) 
	{
		
		ApplicationContext context=new AnnotationConfigApplicationContext(BeansHome.class);
		
		MessageMaker mMaker=context.getBean(MessageMaker.class);
		mMaker.setMessage("get Data bean");
		System.out.println(mMaker.getMessage());
	}
}
