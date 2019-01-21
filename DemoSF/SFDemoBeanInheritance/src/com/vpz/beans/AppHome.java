package com.vpz.beans;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppHome 
{

	public static void main(String[] args) 
	{
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		
		DemoCode dcode=(DemoCode)context.getBean("democodeBean");
//		dcode.setMessage1("Hello World1");
//		dcode.setMessage2("Hellow Wolrd2");
		dcode.getMessage1();
		dcode.getMessage2();
		
		DemoCodeExtender codeExtender=(DemoCodeExtender)context.getBean("democodeextenderBean");
//		codeExtender.setMessage1("Hello India1");
//		codeExtender.setMessage3("Hello India3");
		codeExtender.getMessage1();
		codeExtender.getMessage2();
		codeExtender.getMessage3();

	}

}
