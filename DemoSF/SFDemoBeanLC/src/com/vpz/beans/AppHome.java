package com.vpz.beans;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppHome 
{

	public static void main(String[] args) 
	{
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		
		DemoCode dc=(DemoCode)context.getBean("democodeBean");
		dc.getMessage();
		context.registerShutdownHook();
	}

}
