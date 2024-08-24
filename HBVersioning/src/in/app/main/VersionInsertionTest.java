package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.MobileCustomer;
import in.app.util.HiberbateUtil;

public class VersionInsertionTest {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					MobileCustomer cut = new MobileCustomer("Sachin", 12346789l, "kgf");
					Integer id = (Integer) session.save(cut);
					System.out.println("Id is " + id);
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
				System.out.println("Object saved");
			} else {
				transaction.rollback();
				System.out.println("Object not saved");
			}
			HiberbateUtil.closeSession();
		}
	}

}
