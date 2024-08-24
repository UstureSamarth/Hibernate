package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.InsurancePolicy;
import in.app.util.HiberbateUtil;

public class FirstLevelCache {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		InsurancePolicy ip = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
//					ip = new InsurancePolicy("LIC", "JevanAnand", "monthly", 6);
//					ip = new InsurancePolicy("Axis", "MaxLife", "quater", 6);
					ip = new InsurancePolicy("ICICI", "Samrudhi", "yearly", 10);
					session.save(ip);
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
