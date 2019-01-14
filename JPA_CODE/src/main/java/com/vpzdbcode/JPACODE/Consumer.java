package com.vpzdbcode.JPACODE;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consumer")
public class Consumer
{

	@Id
	int id;
	@Column
	String fname;
	@Column
	String lname;
	@Column(name = "Created_date")
	Date date;

	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setFname(String fname)
	{
		this.fname = fname;
	}

	public String getFname()
	{
		return fname;
	}

	public void setLname(String lname)
	{
		this.lname = lname;
	}

	public String getLname()
	{
		return lname;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Date getDate()
	{
		return date;
	}

	@Override
	public String toString()
	{
		return this.id + "::" + this.fname + "::" + this.lname;
	}
}
