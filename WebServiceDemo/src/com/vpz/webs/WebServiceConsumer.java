package com.vpz.webs;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class WebServiceConsumer 
{

	public static void main(String[] args) throws MalformedURLException 
	{
		
		URL url=new URL("http://localhost:8086/webs/test?wsdl");
		QName name=new QName("http://webs.vpz.com/","InterfaceDataOperationsIMPLService");
		Service service=Service.create(url,name);
		
		InterfaceDataOperations t1=service.getPort(InterfaceDataOperations.class);
		System.out.println(t1.sayHello("vinod"));
	}
}
