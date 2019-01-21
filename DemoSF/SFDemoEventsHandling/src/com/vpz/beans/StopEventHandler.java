package com.vpz.beans;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class StopEventHandler implements ApplicationListener<ContextStoppedEvent> 
{

	public void onApplicationEvent(ContextStoppedEvent arg0) 
	{

		System.out.println("ContextStoppedEvent received.");
	}

	
}
