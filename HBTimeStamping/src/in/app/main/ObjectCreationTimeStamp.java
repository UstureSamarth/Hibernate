package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.BankAccount;
import in.app.util.HiberbateUtil;

public class ObjectCreationTimeStamp {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		BankAccount ba = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					ba = new BankAccount(12345l, "Samarth", 152.3, "Saving");
					session.save(ba);
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
				System.out.println("Account is opened at " + ba.getOpeningDate());
				System.out.println("Account is modified at " + ba.getLastUpdatedDate());
			} else {
				transaction.rollback();
				System.out.println("Object not saved");
			}
			HiberbateUtil.closeSession();
		}
	}

}
