package org.vpz.dbz;

public class Customer
{
	private int id;
	private String fname, lname;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFname()
	{
		return fname;
	}

	public void setFname(String fname)
	{
		this.fname = fname;
	}

	public String getLname()
	{
		return lname;
	}

	public void setLname(String lname)
	{
		this.lname = lname;
	}
	
	@Override
	public String toString()
	{
		return String.format("id:%d firstname:%s, lastname:%s", id,fname,lname);
	}
}
