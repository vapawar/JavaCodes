package nomap;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee
{
	private static SessionFactory factory;

	public static void main(String[] args)
	{
		factory = new Configuration().configure("hbm.cfg.xml").buildSessionFactory();
		ManageEmployee me = new ManageEmployee();
		Integer empID1 = me.addEmployee(82, "Zara", "Ali", 10000);
		Integer empID2 = me.addEmployee(83, "Daisy", "Das", 50080);
		Integer empID3 = me.addEmployee(84, "John", "Paul", 10080);
		me.listEmployees();
		me.updateEmployee(empID1, 5000);
		me.deleteEmployee(empID2);
		me.listEmployees();
		factory.close();
	}

	private Integer addEmployee(int id, String fname, String lname, int salary)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer empID = null;
		try
		{
			tx = session.beginTransaction();
			Employee employee = new Employee(id, fname, lname, salary);
			empID = (Integer) session.save(employee);
			tx.commit();
		}
		catch (HibernateException ex)
		{
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return empID;
	}

	private void listEmployees()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM Employee").list();
			Iterator iterator = employees.iterator();
			while (iterator.hasNext())
			{
				Employee emp = (Employee) iterator.next();
				System.out.println(emp.getId()+" : "+emp.getFirstname() + " " + emp.getLastname() + " " + emp.getSalary());
			}
			tx.commit();
		}
		catch (Exception e)
		{
			if (tx != null)
				tx.rollback();
		}
		finally
		{
			session.close();
		}
		System.out.println("list---------------------------------");
	}

	private void updateEmployee(Integer empID1, int sal)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Employee employee = session.get(Employee.class, empID1);
			employee.setSalary(sal);
			session.update(employee);
			tx.commit();
		}
		catch (Exception e)
		{
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		System.out.println("update------------------------------------");
	}

	private void deleteEmployee(Integer empID2)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Employee employee = session.get(Employee.class, empID2);
			session.delete(employee);
			tx.commit();
		}
		catch (Exception e)
		{
			if (tx != null)
				tx.rollback();
		}
		finally
		{
			session.close();
		}
		System.out.println("delete--------------------------------------");
	}

}
