package com.vpz.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxbDemo 
{
	public static void main(String[] args) throws JAXBException, FileNotFoundException 
	{

		JAXBContext context=JAXBContext.newInstance(Students.class);
		Marshaller marshaller=context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		ArrayList<Student> l1=new ArrayList<>();
		Student s1=new Student();
		s1.setId(12);
		s1.setName("vinod");
		Student s2=new Student();
		s2.setId(15);
		s2.setName("pawar");
		l1.add(s1);
		l1.add(s2);
		Students st=new Students();
		st.setStudents(l1);
		marshaller.marshal(st, new FileOutputStream("test.xml"));
		
		
	}

}
