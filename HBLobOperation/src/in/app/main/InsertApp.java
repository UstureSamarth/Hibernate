package in.app.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.app.Model.JobSeerker;
import in.app.util.HiberbateUtil;

public class InsertApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		JobSeerker js = null;
		byte[] image = null;
		char[] resume = null;
		Integer id = null;

		File imagef = new File("D:\\JavaEE\\Hibernate\\HBLobOperation\\src\\pp.jpg");
		try (FileInputStream fis = new FileInputStream(imagef)) {
			image = new byte[(int) fis.available()];
			fis.read(image);
		}

		File resumef = new File("D:\\JavaEE\\Hibernate\\HBLobOperation\\src\\resume");
		try (FileReader fr = new FileReader(resumef)) {
			resume = new char[(int) resumef.length()];
			fr.read(resume);
		}

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					js = new JobSeerker("Samarth", image, resume, true);
					id = (Integer) session.save(js);
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
				System.out.println("Inserted with id " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not found");
			}
			HiberbateUtil.closeSession();
		}
	}

}
