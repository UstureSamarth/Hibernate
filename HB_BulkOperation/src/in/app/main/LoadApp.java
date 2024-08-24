package in.app.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.util.HiberbateUtil;

public class LoadApp {
	public static void main(String[] args) {
		Session session = null;
		session = HiberbateUtil.getSession();
		try {
			if (session != null) {
				/*
				 * Query<Employee> query = session.createQuery("FROM in.app.Model.Employee");
				 * List<Employee> emp = query.list(); emp.forEach(e -> System.out.println(e));
				 */

				/*
				 * Query<Employee> query = session.
				 * createQuery("FROM in.app.Model.Employee where eNO>=:id1 and eNo<=:id2");
				 * query.setParameter("id1", 1L); query.setParameter("id2", 2L); List<Employee>
				 * emp = query.getResultList(); emp.forEach(e -> System.out.println(e));
				 */

				/*
				 * positional params supported in older versions Query<Employee> query =
				 * session.createQuery("FROM in.app.Model.Employee where eNO>=? and eNo<=?");
				 * query.setParameter(1, 1L); query.setParameter(2, 2L); List<Employee> emp =
				 * query.getResultList(); emp.forEach(e -> System.out.println(e));
				 */
				/*
				 * Query<Employee> query = session.
				 * createQuery("FROM in.app.Model.Employee where eNO>=:id1 and eNo<=:id2");
				 * query.setParameter("id1", 1L); query.setParameter("id2", 2L);
				 * Iterator<Employee> itr = query.iterate(); while(itr.hasNext()) { Employee
				 * emp=(Employee)itr.next(); System.out.println(emp); }
				 */

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
