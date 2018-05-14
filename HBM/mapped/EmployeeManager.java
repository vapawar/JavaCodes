package mapped;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeManager
{
	private static SessionFactory factory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args)
	{
		factory = new Configuration().configure("hbm.cfg.xml").buildSessionFactory();

		EmployeeManager em = new EmployeeManager();
		HashSet set = new HashSet();
		set.add(new Certificate(1, "HCA"));
		set.add(new Certificate(2, "KCA"));
		set.add(new Certificate(3, "MPCA"));
		set.add(new Certificate(4, "BPCA"));
		Integer emp1 = em.addEmployee(12, "vinod", "Pawar", 2630000, set);

		HashSet set2 = new HashSet();
		set2.add(new Certificate(11, "KXT"));
		set2.add(new Certificate(12, "AXT"));
		Integer emp2 = em.addEmployee(15, "aryan", "rathore", 3480000, set2);

		em.listEmployee();
		em.updateEmployee(emp1, 606000);
		em.deleleEmployee(emp2);
		em.listEmployee();

		factory.close();
	}

	private Integer addEmployee(int id, String fname, String lname, int sal, HashSet set)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer empID = null;

		try
		{
			tx = session.beginTransaction();
			Employee emp = new Employee(id, fname, lname, sal);
			emp.setCerts(set);
			empID = (Integer) session.save(emp);
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
			if (session != null)
				session.close();
		}

		return empID;
	}

	private void deleleEmployee(Integer emp2)
	{
	}

	private void updateEmployee(Integer emp1, int i)
	{
	}

	private void listEmployee()
	{
	}
}
