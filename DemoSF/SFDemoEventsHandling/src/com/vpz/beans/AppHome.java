package com.vpz.beans;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppHome 
{

	public static void main(String[] args) 
	{
		
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		
		context.start();
		
		HelloWorld hc=(HelloWorld)context.getBean("hcBean");
		hc.getMessage();
		
		context.stop();
	}
}
