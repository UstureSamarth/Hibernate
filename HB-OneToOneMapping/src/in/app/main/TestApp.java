package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.Account;
import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class TestApp {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		Integer id = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
					transaction = session.beginTransaction();
					if (transaction != null) {
						Account acc = new Account(121, "Sachin", "Saving");
						Employee emp = new Employee("Sachin", 100.0f, "MI", acc);
						flag = true;
						id = (Integer) session.save(emp);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("Object inserted with id " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted");
			}
			HiberbateUtil.closeSession();
		}
	}

}
