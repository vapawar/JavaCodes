package org.vpz.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbTest 
{
	public static void main(String[] args) throws JAXBException, IOException 
	{
		
		JAXBContext context=JAXBContext.newInstance(StoarageMetaWrapper.class);
		Marshaller marshaller=context.createMarshaller();
		marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
		FileOutputStream out=new FileOutputStream("test.xml");
		
		StoarageMetaWrapper smw=new StoarageMetaWrapper();
		ArrayList<StorageMetas>s=new ArrayList<>();
		
		StorageMetas sm1=new StorageMetas();
		sm1.setType("RAID01");
		sm1.setNumber(8);
		sm1.setName("Cluster01");
		StorageMetas sm2=new StorageMetas();
		sm2.setType("RAID02");
		sm2.setNumber(16);
		sm2.setName("Cluster02");
		s.add(sm1);
		s.add(sm2);
		smw.setData(s);
		marshaller.marshal(smw,out);
		out.close();
		System.out.println("output saved.");
		
		FileInputStream in=new FileInputStream("test.xml");
		Unmarshaller unmarshaller=context.createUnmarshaller();
		smw=(StoarageMetaWrapper) unmarshaller.unmarshal(in);
		s=smw.getData();
		
		for(int i=0;i<s.size();i++)
		{
			sm1=s.get(i);
			System.out.println("type:"+sm1.getType());
			System.out.println("Number: "+sm1.getNumber());
			System.out.println("Name:"+sm1.getName());
			
		}
		in.close();
	}
}
