package com.vpz.webs.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello 
{
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayTextHello()
	{
		return "Hello Vinod....text call";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXmlHello()
	{
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><message>Hello Vinod... xml call</message>";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello()
	{
		return "<html><body>Hello Vinod... html call</body></html>";
	}
	
	@POST
	@Produces(MediaType.TEXT_XML)
	public String sayPostXmlHello()
	{
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><message>Hello Vinod... xml call</message>";
	}

}
