package test26;

public class DataOps
{
	
	public String getReverse(String str)
	{
	return new StringBuffer(str).reverse().toString();
	}

	public String getUpper(String str)
	{
	return str.toUpperCase();
	}
	public String getLower(String str)
	{
	return str.toLowerCase();
	}
}
