package com.vpz.beans;

public class LoggingTest 
{

	public void beforeAdvice()
	{
		System.out.println("Going to set student profile.");
	}
	
	public void afterAdvice()
	{
		System.out.println("Student profile has been setup.");
	}
	
	public void afterReturningAdvice(Object retval)
	{
		System.out.println("Returning : "+retval.toString());
	}
	
	public void afterThrowingAdvice(IllegalArgumentException ex)
	{
		System.out.println("There has been en exception.");
	}
}
