package org.vpz.test;

import java.util.Arrays;

public class ArrayMaxSum 
{
	public static void main(String[] args) 
	{		
		int a[]={4, 1, 3, 5, 6};//{2,3,2,2}};//{3,2,8,1,3,9};
		int sum=0;
		
		System.out.println(Arrays.toString(a));
		
		Arrays.sort(a);	
		
		for (int i=0; i<a.length ; i++)
		{
		    sum = sum + a[i]*(i+1);
		}
		System.out.println(sum);
	}
}
