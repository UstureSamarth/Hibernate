package in.app.main;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.app.Model.Employee;
import in.app.util.HiberbateUtil;

public class LoadApp4 {
	public static void main(String[] args) {
		Session session = null;
		session = HiberbateUtil.getSession();
		try {
			if (session != null) {
				Query query = session.createQuery("from in.app.Model.Employee where eNo=:id");
				query.setParameter("id", 2L);
				/*
				 * Employee emp = (Employee) query.uniqueResult(); if(emp!=null)
				 * System.out.println(emp); else System.out.println("Record not found");
				 */
				Optional<Employee> optional = query.uniqueResultOptional();
				if (optional.isPresent()) {
					Employee emp = optional.get();
					System.out.println(emp);
				} else
					System.out.println("Record not found");

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
