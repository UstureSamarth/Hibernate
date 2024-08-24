package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class DeleteApp {

	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					Employee emp = session.get(Employee.class, 18);
					if (emp != null) {
						session.delete(emp);
						flag = true;
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("Object deleted");
			} else {
				transaction.rollback();
				System.out.println("Object not deleted");
			}
			HiberbateUtil.closeSession();
		}
	}

}
