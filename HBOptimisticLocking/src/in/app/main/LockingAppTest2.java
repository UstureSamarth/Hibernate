package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.InsurancePolicy;
import in.app.util.HiberbateUtil;

public class LockingAppTest2 {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					InsurancePolicy ip=session.get(InsurancePolicy.class, 3L);
					System.out.println(ip);
					ip.setTenure(22);
					flag=true;
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
