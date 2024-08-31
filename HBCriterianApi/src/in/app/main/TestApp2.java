package in.app.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import in.app.Model.Project;
import in.app.util.HiberbateUtil;

public class TestApp2 {

	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				Criteria criteria = session.createCriteria(Project.class);

				PropertyProjection p1 = Projections.property("teamSize");
				PropertyProjection p2 = Projections.property("location");
				PropertyProjection p3 = Projections.property("pName");
				
				ProjectionList pl=Projections.projectionList();
				pl.add(p1);
				pl.add(p2);
				pl.add(p3);

				criteria.setProjection(pl);
				List<Object[]> l = criteria.list();
				l.forEach(o->{
					for(Object i:o) {
						System.out.print(i+" ");
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
