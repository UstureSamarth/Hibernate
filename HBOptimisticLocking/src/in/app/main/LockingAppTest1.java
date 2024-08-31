package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.InsurancePolicy;
import in.app.util.HiberbateUtil;

public class LockingAppTest1 {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					InsurancePolicy ip = session.get(InsurancePolicy.class, 3L, LockMode.UPGRADE_NOWAIT);
					System.out.println(ip);
					Thread.sleep(30000);
					ip.setTenure(12);
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
				System.out.println("Object not updated");
			}
			HiberbateUtil.closeSession();
		}
	}

}
