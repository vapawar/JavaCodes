package org.vpz.test;

public class BubbleSortX 
{

	public static void main(String[] args) 
	{
		BubbleSortX x=new BubbleSortX();
		int [] data={12,32,4,65,56,34,8,3434,13};
		x.BubbleSort(data);
		for (int i : data) 
		{
			System.out.println(i);
		}		
	}
	
	public void BubbleSort(int [] sdata)
	{
		int length=sdata.length;
		
		for(int i=0; i<length-1;i++)
		{
			for(int j=0;j<length-i-1;j++ )
			{
				if(sdata[j] > sdata[j+1])
				{
					int temp=sdata[j];
					sdata[j]=sdata[j+1];
					sdata[j+1]=temp;
				}
			}
		}
	}
}
