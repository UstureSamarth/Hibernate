package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.Model.InsurancePolicy;
import in.app.util.HiberbateUtil;

public class SecondLevelCache {
	public static void main(String[] args) {
		Session session = null;
		InsurancePolicy ip = null;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				ip = session.get(InsurancePolicy.class, 1L);
				System.out.println("1: " + ip);
				session.evict(ip);
				ip = session.get(InsurancePolicy.class, 1L);// get from l2 keep in l1
				System.out.println("2: " + ip);
				session.clear();
				Thread.sleep(20000);
				ip = session.get(InsurancePolicy.class, 1L);
				System.out.println("3: " + ip);
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
