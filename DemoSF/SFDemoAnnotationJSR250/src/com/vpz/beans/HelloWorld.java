package com.vpz.beans;

import javax.annotation.*;

public class HelloWorld 
{

	String message;
	
	public void setmessage(String message) 
	{
		this.message = message;
	}
	
	public String getmessage() 
	{
		System.out.println("the message is : "+message);
		return message;
	}
	
	@PostConstruct
	public void init()
	{
		System.out.println("Bean going through init.");
	}
	
	@PreDestroy
	public void destroy()
	{
		System.out.println("Bean will destroy now.");
	}
}
