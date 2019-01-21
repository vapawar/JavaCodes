package com.vpz.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcesses implements BeanPostProcessor 
{

	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1) throws BeansException 
	{
		System.out.println("AfterInitialization "+bean);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1) throws BeansException 
	{
		System.out.println("BeforeInitialization "+bean);
		return bean;
	}
}
