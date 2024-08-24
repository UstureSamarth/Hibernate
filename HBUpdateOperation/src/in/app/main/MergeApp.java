package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class MergeApp {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;

		Employee e1 = null;
		Employee e2 = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					e1 = new Employee();
					e1 = session.get(Employee.class, 2);
					e2 = new Employee();
					e2.setEmpId(2);
					e2.setEmpName("Yuvraj");
					e2.setEmpSal(12.52);
					Employee e3 = (Employee) session.merge(e2);

					flag = true;
					System.out.println(e1);
					System.out.println(e2);
					System.out.println(e3);
					System.out.println(e1.hashCode() + ":" + e2.hashCode() +" "+ e3.hashCode());

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
