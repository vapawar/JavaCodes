package com.vpz.beans;

public class DemoCode 
{
	private String message;
	
	public void setMessage(String message) 
	{
		this.message = message;
	}
	public void getMessage() 
	{
		System.out.println("your message is : "+message);
	}
	
	public void init()
	{
		System.out.println("In the init method");
	}
	public void destroy()
	{
		System.out.println("In the destroy method");
	}

}
