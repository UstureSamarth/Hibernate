package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.app.util.HiberbateUtil;

public class DeleteRecordApp {
	public static void main(String[] args) {
		Session session = null;
		session = HiberbateUtil.getSession();
		Transaction transaction = null;
		Integer count = 0;
		Boolean flag = false;
		try {
			if (session != null) {
				transaction = session.beginTransaction();
				Query query = session.createQuery("delete from in.app.Model.Employee where eNo>:id");
				query.setParameter("id", 3L);
				count = query.executeUpdate();
				if (count > 0) {
					flag = true;
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No of records deleted are "+count);
			} else {
				transaction.rollback();
			}
			HiberbateUtil.closeSession();
		}
	}
}
