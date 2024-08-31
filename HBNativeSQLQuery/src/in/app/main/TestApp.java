package in.app.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.app.Model.InsurancePolicy;
import in.app.util.HiberbateUtil;

public class TestApp {

	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				NativeQuery<Object[]> query = session.getNamedNativeQuery("GET_ALL_POLICY_TYPE");
				query.setParameter("type", "MaxLife");
				List<Object[]> l = query.getResultList();
				l.forEach(o -> {
					for (Object i : o) {
						System.out.print(i + " ");
					}
				});
				System.out.println();
				
				NativeQuery<InsurancePolicy> query2 = session.getNamedNativeQuery("GET_ALL_POLICIES");
				List<InsurancePolicy> l2 = query2.getResultList();
				l2.forEach(i -> {
					System.out.println(i);
				});
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
