package test;

public class DataWorker implements BaseData
{

	@Override
	public void say() 
	{
		System.out.println("Hello from subs default..");
	}
	
	
	public static void main(String[] args) 
	{
	
		BaseData.sayNow();
		new DataWorker().say();
		System.out.println(abc);
	}
}
