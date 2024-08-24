package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class DBRowToEntityApp {

	public static void main(String[] args) {

		Session session = null;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				Employee emp = session.get(Employee.class, 45);
				System.out.println("Before modification :" + emp);
				System.in.read();
				session.refresh(emp);
				System.out.println("After modification :" + emp);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
