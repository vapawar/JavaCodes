package com.vpz.webs.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class RestClient 
{

	public static void main(String[] args) 
	{
		
		ClientConfig config=new ClientConfig();
		Client client=ClientBuilder.newClient(config);
		WebTarget target=client.target(UriBuilder.fromUri("http://localhost:8086/RestDemo").build());
		System.out.println(target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class));
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println(target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class));
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println(target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class));
	}
}
