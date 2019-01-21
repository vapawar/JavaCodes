package com.vpz.beans;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class AppHome 
{

	public static void main(String[] args) 
	{
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("Beans.xml"));
		
		DemoCode dc=(DemoCode)factory.getBean("democodeBean");
		dc.setMessage("Hello Vinod...");
		dc.getMessage();

	}

}
