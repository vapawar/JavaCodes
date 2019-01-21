package com.vpz.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppHome 
{

	public static void main(String[] args) 
	{
	
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		
		DemoCode dc=(DemoCode)context.getBean("democodeBean");
		dc.setMessage("I am code A");
		dc.getMessage();
		
		DemoCode dc2=(DemoCode)context.getBean("democodeBean");
		dc2.getMessage();

	}

}
