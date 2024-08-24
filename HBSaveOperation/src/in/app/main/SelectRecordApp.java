package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {

		Session session = null;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				Employee emp = session.load(Employee.class, 1);
				System.out.println(emp);
			}
		} catch (HibernateException e) {
			System.out.println("Record not found");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HiberbateUtil.closeSession();
		}
	}

}
