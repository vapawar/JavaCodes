package com.vpz.webs;

import java.io.Serializable;

public class Student implements Serializable
{	
	private int srno;
	private String name;
	private String surname;
	private String course;	
	
	public int getSrno() 
	{
		return srno;
	}
	public void setSrno(int srno) 
	{
		this.srno = srno;
	}
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getSurname() 
	{
		return surname;
	}
	public void setSurname(String surname) 
	{
		this.surname = surname;
	}
	public String getCourse() 
	{
		return course;
	}
	public void setCourse(String course) 
	{
		this.course = course;
	}
	
	public String toString()
	{
		return "srno:"+this.srno+",name:"+this.name+",surname:"+this.surname+",course:"+this.course;
	}
}
