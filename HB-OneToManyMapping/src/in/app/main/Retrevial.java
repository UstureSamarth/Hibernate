package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.Model.Department;
import in.app.util.HiberbateUtil;

public class Retrevial {

	public static void main(String[] args) {

		Session session = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				Department dept = session.get(Department.class, "India");
				System.out.println(dept);
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
