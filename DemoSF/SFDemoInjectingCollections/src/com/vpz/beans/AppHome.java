package com.vpz.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppHome
{
	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		
		JavaCollectionsDemo jc=(JavaCollectionsDemo)context.getBean("cdBean");
		jc.getList();
		jc.getSet();
		jc.getMap();
		jc.getProps();
		
	}
}
