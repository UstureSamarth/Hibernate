package in.app.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.app.Model.Project;
import in.app.util.HiberbateUtil;

public class TestApp {

	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<Project> CQuery = builder.createQuery(Project.class);
				Root<Project> root = CQuery.from(Project.class);
				CQuery.select(root);
				Query<Project> query = session.createQuery(CQuery);
				List<Project> l = query.getResultList();
				l.forEach(System.out::println);
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
