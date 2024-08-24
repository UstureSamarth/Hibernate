package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.BankAccount;
import in.app.util.HiberbateUtil;

public class ObjectModificationTimeStamp {

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
					ba = session.get(BankAccount.class, 1L);
					if (ba != null) {
						ba.setHolderName("UstureSamarth");
						ba.setBalance(1522.3);
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
				System.out.println("Account is opened at " + ba.getOpeningDate());
				System.out.println("Account is modified at " + ba.getLastUpdatedDate());
			} else {
				transaction.rollback();
				System.out.println("Object not modified");
			}
			HiberbateUtil.closeSession();
		}
	}

}
