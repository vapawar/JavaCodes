package com.vpz.webs;

import javax.jws.WebService;

@WebService(endpointInterface="com.vpz.webs.InterfaceDataOperations")
public class InterfaceDataOperationsIMPL implements InterfaceDataOperations
{

	@Override
	public String sayHello(String message) 
	{
		Student st=new Student();
		st.setSrno(12);
		st.setName("Vinod");
		st.setSurname("Pawar");
		st.setCourse("Java");
		//return "Hello "+message+" ...";
		return message+":Details are as follows,"+st.toString();
	}

}
