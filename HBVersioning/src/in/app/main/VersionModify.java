package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.MobileCustomer;
import in.app.util.HiberbateUtil;

public class VersionModify {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					MobileCustomer cust = session.get(MobileCustomer.class, 1);
					if (cust != null) {
						cust.setCallerTune("Ugram");
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
				System.out.println("Object modified");
			} else {
				transaction.rollback();
				System.out.println("Object not modified");
			}
			HiberbateUtil.closeSession();
		}
	}

}
