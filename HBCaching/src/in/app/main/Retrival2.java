package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.Model.InsurancePolicy;
import in.app.util.HiberbateUtil;

public class Retrival2 {

	public static void main(String[] args) {

		Session session = null;
		InsurancePolicy ip1 = null;
		InsurancePolicy ip2 = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				ip1 = session.get(InsurancePolicy.class, 1L);
				System.out.println("IP 1 :" + ip1);
				System.in.read();
				ip2 = session.get(InsurancePolicy.class, 1L);
				System.out.println("IP 2 :" + ip2);
				if (ip1.hashCode() == ip2.hashCode()) {
					System.out.println("Ip1 and Ip2 are same");
				}
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
