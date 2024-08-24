package in.app.main;

import org.hibernate.cfg.Configuration;

import in.app.Model.Employee;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee e = new Employee();
		e.setEmpId(7);
		e.setEmpName("Dhoni");
		e.setEmpSal(557.89); 
		Serializable id = session.save(e);
		System.out.println("Serializable value return by save "+id);
		transaction.commit();
		session.close();

	}

}
