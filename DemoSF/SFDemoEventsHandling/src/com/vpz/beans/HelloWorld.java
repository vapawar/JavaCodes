package com.vpz.beans;

public class HelloWorld 
{
	
	String message;
	
	public void setMessage(String message) 
	{
		this.message = message;
	}
	public void getMessage() 
	{
		System.out.println("your message is : "+message);
	}
}
