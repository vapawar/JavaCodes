package com.vpz.webs;

import javax.jws.WebService;

@WebService(endpointInterface="com.vpz.webs.InterfaceDataOperations")
public class InterfaceDataOperationsIMPL implements InterfaceDataOperations
{

	@Override
	public String sayHello(String message) 
	{	return "Hello "+message+" ...";
	}

}
