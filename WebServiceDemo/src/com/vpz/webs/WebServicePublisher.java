package com.vpz.webs;

import javax.xml.ws.Endpoint;

public class WebServicePublisher 
{
	public static void main(String[] args) 
	{
		
		Endpoint endpoint=Endpoint.publish("http://localhost:8086/webs/test", new InterfaceDataOperationsIMPL());
	}

}
