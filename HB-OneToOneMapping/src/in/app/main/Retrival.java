package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class Retrival {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Employee emp = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				emp = session.get(Employee.class, 1);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				System.out.println(emp);
			} else {
				System.out.println("Object not found");
			}
			HiberbateUtil.closeSession();
		}
	}

}
