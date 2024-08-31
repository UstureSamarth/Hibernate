package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.Branch;
import in.app.Model.Student;
import in.app.util.HiberbateUtil;

public class TestApp {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		String result = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					Branch b=new Branch(121,"IT","VIT");
					Student s1=new Student("Samarth", b);
					Student s2=new Student("Sudhir", b);
					Student s3=new Student("Usture", b);
					session.save(s1);
					session.save(s2);
					session.save(s3);
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
				System.out.println("Object inserted ");
			} else {
				transaction.rollback();
				System.out.println("Object not inserted");
			}
			HiberbateUtil.closeSession();
		}
	}

}
