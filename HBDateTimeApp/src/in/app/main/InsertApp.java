package in.app.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.PersonInfo;
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
					PersonInfo info = new PersonInfo("Sachin", "MI", LocalDate.of(1973, 4, 23),
							LocalDateTime.of(1987, 6, 21, 12, 35), LocalTime.of(10, 45));
					session.save(info);
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
			}
			HiberbateUtil.closeSession();
		}
	}

}
