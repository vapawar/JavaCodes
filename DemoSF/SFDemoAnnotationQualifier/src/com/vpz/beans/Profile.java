package com.vpz.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile 
{

	@Autowired
	@Qualifier("student1")
	
	Student studetnt;
	
	public Profile() 
	{
		System.out.println("Inside profile constructor.");
	}
	
	public void showAge()
	{
		System.out.println("Age is : "+studetnt.getAge());
	}
	public void showName()
	{
		System.out.println("Name is : "+studetnt.getName());
	}
}
