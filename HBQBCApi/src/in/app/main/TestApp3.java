package in.app.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.app.Model.Project;
import in.app.util.HiberbateUtil;

public class TestApp3 {

	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<Object[]> CQuery = builder.createQuery(Object[].class);
				Root<Project> root = CQuery.from(Project.class);
				CQuery.multiselect(root.get("pid"), root.get("pName"));
				Query<Object[]> query = session.createQuery(CQuery);

				List<Object[]> l = query.getResultList();
				l.forEach(row -> {
					for (Object i : row) {
						System.out.print(i + " ");
					}
					System.out.println();
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
