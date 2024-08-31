package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.Model.Student;
import in.app.util.HiberbateUtil;

public class Retrevial {

	public static void main(String[] args) {

		Session session = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				Student s1=session.get(Student.class, 1);
				Student s2=session.get(Student.class, 2);
				System.out.println(s1);
				System.out.println(s2);		
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HiberbateUtil.closeSession();
		}
	}

}
