package com.vpz.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AppHome 
{

	public static void main(String[] args) 
	{
		
		ApplicationContext context=new FileSystemXmlApplicationContext("C:/Users/vpx/workspace/SFDemoAppContext/src/beans.xml");
		
		DemoCode dc=(DemoCode)context.getBean("democodeBean");
		dc.setMessage(" Hi App context");
		dc.getMessage();
	}

}
