package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class EmployeeSaveApp {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		Integer id = null;
		Employee emp = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					emp = new Employee("Sachin", 1000.12);
					id = (Integer) session.save(emp);
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
				System.out.println("Object saved with id " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not saved");
			}
			HiberbateUtil.closeSession();
		}
	}

}
