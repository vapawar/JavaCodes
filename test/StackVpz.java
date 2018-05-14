package test;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("all")
public class StackVpz 
{

	public static void main(String[] args) 
	{
		StackCustom sc=new StackCustom(4);
		System.out.println(sc.pop());
		sc.push(123);
		System.out.println(sc.pop());
		System.out.println(sc.pop());
		
		ArrayList a=new ArrayList<Object>();
		System.out.println("List size"+a.size());
		a.add(12);
		a.add(12);
		System.out.println("List size"+a.size());
		Collections.sort(a);
		System.out.println("List size"+a.size());
		
	}
}

class StackCustom
{
	private int []a;
	private int count=-1;
	
	public  StackCustom(int size)
	{
		a=new int[size];
	}
	
	public void push(int data)
	{
		if(count==a.length)
			System.out.println("stack overflow");
		else
		{
			count++;
			a[count]=data;
		}
	}
	public int pop()
	{
		int data;
		if(count==-1)
		{
			System.out.println("Empty stack");
			return -1;
		}
		else
		{
			data=a[count];
			count--;
		}
		return data;
	}
}