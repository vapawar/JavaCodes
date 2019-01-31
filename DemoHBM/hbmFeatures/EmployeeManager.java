package hbmFeatures;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmployeeManager
{
	private static SessionFactory factory = null;

	public static void main(String[] args)
	{
		factory = new Configuration().configure("hbm.cfg.xml").buildSessionFactory();
		EmployeeManager em = new EmployeeManager();
		em.addEmployee(673, "test", "data", 48000);
		em.listEmployees();
		em.countEmployees();
		em.totalSalary();
		factory.close();
	}

	private void addEmployee(int id, String fname, String lname, int sal)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Employee emp = new Employee();
			emp.setId(id);
			emp.setFname(fname);
			emp.setLname(lname);
			emp.setSalary(sal);
			session.save(emp);
			tx.commit();
		}
		catch (Exception ex)
		{
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}

	private void listEmployees()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Employee.class);
			cr.add(Restrictions.gt("salary", 25000));
			List data = cr.list();
			Iterator mover = data.iterator();
			while (mover.hasNext())
			{
				Employee emp = (Employee) mover.next();
				System.out.println(emp.getId() + " : " + emp.getFname() + " : " + emp.getLname() + ": " + emp.getSalary());
			}
		}
		catch (Exception ex)
		{
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}

	private void countEmployees()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Employee.class);
			cr.setProjection(Projections.rowCount());
			List data = cr.list();
			System.out.println("Employees Count" + data);
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
	}

	private void totalSalary()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Employee.class);
			cr.setProjection(Projections.sum("salary"));
			List data = cr.list();
			System.out.println("Toatal salry: " + data);
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
	}
}
