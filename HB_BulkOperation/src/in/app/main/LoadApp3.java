package in.app.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.app.util.HiberbateUtil;

public class LoadApp3 {
	public static void main(String[] args) {
		Session session = null;
		session = HiberbateUtil.getSession();
		try {
			if (session != null) {
				Query query = session.createQuery("select eName from in.app.Model.Employee where eNo<=:id");
				query.setParameter("id", 2L);
				List<Object> l = query.getResultList();
				for(Object o:l) {
					System.out.println(o);
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
