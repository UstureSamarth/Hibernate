package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.ProgrammerProjectInfo;
import in.app.Model.ProjectInfo;
import in.app.util.HiberbateUtil;

public class CompositeKeyApp {
	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					ProjectInfo info = new ProjectInfo(101, 903);
					ProgrammerProjectInfo details = new ProgrammerProjectInfo(info, "Dhoni", 7, "JavaEE");
					ProjectInfo id = (ProjectInfo) session.save(details);
					System.out.println(id);
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
			} else {
				transaction.rollback();
			}
			HiberbateUtil.closeSession();
		}
	}
}
