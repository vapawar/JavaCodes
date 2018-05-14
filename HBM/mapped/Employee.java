package mapped;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee
{
	@Id
	@Column
	private int id;

	@Column(name = "first_name")
	private String fname;

	@Column(name = "last_name")
	private String lname;

	@Column
	private int salary;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private Set<Certificate> certs;

	public Employee()
	{
	}

	public Employee(int id, String fname, String lname, int sal)
	{
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.salary = sal;
	}

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

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	public Set getCerts()
	{
		return certs;
	}

	public void setCerts(Set certs)
	{
		this.certs = certs;
	}
}
