package in.app.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.Department;
import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class TestApp {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		String result = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					Employee e1 = new Employee("Sachin", 150.0f, "MI");
					Employee e2 = new Employee("Virat", 145.0f, "CSK");
					Employee e3 = new Employee("Dhoni", 120.0f, "RCB");
					Set<Employee> set = new HashSet<Employee>();
					set.add(e1);
					set.add(e2);
					set.add(e3);

					Department dept = new Department("India", "IPL", set);
					result = (String) session.save(dept);
					flag = true;

				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("Object inserted with id " + result);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted");
			}
			HiberbateUtil.closeSession();
		}
	}

}
