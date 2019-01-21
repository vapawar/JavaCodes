 package soap;

import javax.xml.ws.Endpoint;

import soap.MessageWriterIMPL;

public class SoapServer 
{
	public static void main(String[] args) 
	{
		Endpoint.publish("http://localhost:8286/MessageWriter",new MessageWriterIMPL());
	}
}
