package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class saveOrUpdateApp {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;

		Employee emp = new Employee();
		emp.setEmpId(45);
		emp.setEmpName("Rohit");
		emp.setEmpSal(152.0);
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					session.saveOrUpdate(emp);
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
				System.out.println("Object updated");
			} else {
				transaction.rollback();
				System.out.println("Object not found");
			}
			HiberbateUtil.closeSession();
		}
	}

}
