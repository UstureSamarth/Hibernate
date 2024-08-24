package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class SelectRecordAppUsingGet {

	public static void main(String[] args) {

		Session session = null;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				Employee emp = session.get(Employee.class, 1);
				if (emp != null) {
					System.out.println("Empid is " + emp.getEmpId());
					System.in.read();
				} else {
					System.out.println("Record not found");

				}
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
