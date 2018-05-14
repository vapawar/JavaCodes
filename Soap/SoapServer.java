 package org.vpz.webs.soaps;

import javax.xml.ws.Endpoint;

import org.vpz.webs.soaps.MessageWriterIMPL;

public class SoapServer 
{
	public static void main(String[] args) 
	{
		Endpoint.publish("http://localhost:8286/MessageWriter",new MessageWriterIMPL());
	}
}
