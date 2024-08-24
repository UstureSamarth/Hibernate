package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class InsertApp {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					Employee emp = new Employee();
					emp.setEmpName("Kohli");
					emp.setEmpSal(781.89);
					session.save(emp);
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
			} else {
				transaction.rollback();
			}
			HiberbateUtil.closeSession();
		}
	}

}
