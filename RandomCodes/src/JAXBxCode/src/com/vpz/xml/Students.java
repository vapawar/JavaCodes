package com.vpz.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Students 
{
	ArrayList<Student> students=null;
	@XmlElement(name="student")
	public ArrayList<Student> getStudents() 
	{
		return students;
	}
	public void setStudents(ArrayList<Student> students) 
	{
		this.students = students;
	}
	

}
