package in.app.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.app.Model.Employee;

public class StandardApp {

	public static void main(String[] args) {

		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer idValue = null;
		Boolean flag=true;

		Employee emp = new Employee();
		emp.setEmpId(7);
		emp.setEmpName("Dhoni");
		emp.setEmpSal(557.89);

		cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		System.out.println(cfg.getProperties());

		try {
			transaction = session.beginTransaction();
			idValue = (Integer) session.save(emp);
			System.out.println("Serializable value return by save " + idValue);
			flag=true;
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(flag==true) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			session.close();
			sessionFactory.close();
		}

	}

}
