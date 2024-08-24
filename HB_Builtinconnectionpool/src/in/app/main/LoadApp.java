package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.Model.InsurancePolicy;
import in.app.util.HiberbateUtil;

public class LoadApp {
	public static void main(String[] args) {
		Session session = null;
		InsurancePolicy policy = null;
		session = HiberbateUtil.getSession();
		try {
			if (session != null) {
				policy = session.get(InsurancePolicy.class, 1L);
				if (policy != null) {
					System.out.println(policy);
				} else {
					System.out.println("Record not found");
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HiberbateUtil.closeSession();
		}
	}
}
