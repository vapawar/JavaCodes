package com.vpz.xcodes;

public class PrivateConstructorDemo 
{

	private static PrivateConstructorDemo privateConstructorDemo=null;
	int number;
	String str;
	
	private PrivateConstructorDemo()
	{
		System.out.println("Hello from constructor");
	}
	public static PrivateConstructorDemo getInstance()
	{
		if(privateConstructorDemo==null)
			privateConstructorDemo=new PrivateConstructorDemo();
		return privateConstructorDemo;
	}	
	
	public PrivateConstructorDemo getData(int num, String str)
	{
		System.out.println("Number: "+num);
		System.out.println("String: "+str);
		return null;
	}
	
	public static void main(String[] args) 
	{
	
		PrivateConstructorDemo st=PrivateConstructorDemo.getInstance();
		st.getData(12, "vpawar");
	}
}
