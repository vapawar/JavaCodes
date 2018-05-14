package org.vpz.test;

import java.util.ArrayList;

@SuppressWarnings("all")
public class ArraySwapper 
{
	public static void main(String[] args) 
	{
		ArraySwapper as=new ArraySwapper();
		int []inputs={12,34,48,476,54,328,98};
		for (int i : inputs)
			System.out.println(i);
		as.swapIndex(inputs);
		System.out.println("------");
		for (int i : inputs)
			System.out.println(i);
		as.swapArray();
	}
	
	public void swapIndex( int[] data)
	{
		int temp=0;
		for(int i=0;i<data.length-1;i++)
		{
				temp=data[i];
				data[i]=data[++i];
				data[i]=temp;	
		}
	}
	
	public void swapArray()
	{
		ArrayList a=new ArrayList<>();
		a.add(12);
		a.add(33);
		a.add(54);
		a.add(9);
		a.add(82);
		a.add(39);
		a.add(89);
		a.add(28);
		System.out.println("-- -- --");
		System.out.println(a);
		int sz=a.size();
		for(int i=0;i<sz-1;i=i+2)
		{
			int temp1=(int) a.remove(i);
			int temp2=(int) a.remove(i);
			a.add(i, temp1);
			a.add(i, temp2);
		}
		System.out.println(a);
	}
}
