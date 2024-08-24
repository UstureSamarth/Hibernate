package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.Model.InsurancePolicy;
import in.app.util.HiberbateUtil;

public class Retrival {

	public static void main(String[] args) {

		Session session = null;
		InsurancePolicy ip = null;
		/*
		 * Transaction transaction = null; Boolean flag = false;
		 * 
		 * 
		 * try { session = HiberbateUtil.getSession(); if (session != null) {
		 * transaction = session.beginTransaction(); ip =
		 * session.get(InsurancePolicy.class, 1L); if (ip != null) {
		 * System.out.println(ip); ip.setTenure(9); session.update(ip);
		 * ip.setTenure(30); session.update(ip); flag=true; } else {
		 * System.out.println("Record not found"); } }
		 */

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				ip = session.get(InsurancePolicy.class, 1L);
				System.in.read();
				System.out.println("1-" + ip);
				ip = session.get(InsurancePolicy.class, 1L);
				System.in.read();
				System.out.println("2-" + ip);
				session.evict(ip);
				ip = session.get(InsurancePolicy.class, 1L);
				System.in.read();
				System.out.println("3-" + ip);
				ip = session.get(InsurancePolicy.class, 1L);
				System.in.read();
				System.out.println("4-" + ip);
				session.clear();
				System.in.read();
				ip = session.get(InsurancePolicy.class, 1L);
				System.out.println("5-" + ip);

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
