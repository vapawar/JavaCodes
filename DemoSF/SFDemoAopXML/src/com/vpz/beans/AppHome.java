package com.vpz.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppHome 
{
	
	public static void main(String[] args) 
	{

		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		
		Student student=(Student)context.getBean("stBean");
		student.getAge();
		student.getName();
		student.showException();
	}

}
