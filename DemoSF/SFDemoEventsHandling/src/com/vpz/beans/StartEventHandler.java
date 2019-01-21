package com.vpz.beans;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class StartEventHandler implements ApplicationListener<ContextStartedEvent>
{
	public void onApplicationEvent(ContextStartedEvent arg0) 
	{
		
		System.out.println("ContextStartedEvent received.");
	}
}
