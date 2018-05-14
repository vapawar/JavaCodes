package soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SoapClient 
{
	
	public static void main(String[] args) throws MalformedURLException 
	{
		
		URL url=new URL("http://localhost:8286/MessageWriter?WSDL");
		QName qname=new QName("http://webs.vpz.com/","MessageWriterIMPLService");
		
		Service service=Service.create(url, qname);
		MessageWriter m=service.getPort(MessageWriter.class);
		m.setMessage("The data is as shown below.");
	}
}
