package in.app.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.Course;
import in.app.Model.Student;
import in.app.util.HiberbateUtil;

public class TestApp {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					Course c1 = new Course("C-111", "Java", 100);
					Course c2 = new Course("C-121", "JEE", 150);
					Course c3 = new Course("C-131", "Spring", 200);

					Set<Course> set = new HashSet<Course>();
					set.add(c1);
					set.add(c2);
					set.add(c3);

					Student s1 = new Student("Samarth", set);
					Student s2 = new Student("Sudhir", set);

					session.save(s1);
					session.save(s2);
					flag = true;

				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("Object inserted ");
			} else {
				transaction.rollback();
				System.out.println("Object not inserted");
			}
			HiberbateUtil.closeSession();
		}
	}

}
