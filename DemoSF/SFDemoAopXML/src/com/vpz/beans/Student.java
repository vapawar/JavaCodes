package com.vpz.beans;

public class Student 
{
	
	Integer age;
	String name;
	
	public void setAge(Integer age) 
	{
		this.age = age;
	}
	public Integer getAge() 
	{
		System.out.println("Age is : "+age);
		return age;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getName() 
	{
		System.out.println("Name is: "+name);
		return name;
	}
	
	public void showException()
	{
		System.out.println("Exception raised.");
		throw new IllegalArgumentException();
	}

}
