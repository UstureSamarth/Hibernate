package in.app.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.app.Model.JobSeerker;
import in.app.util.HiberbateUtil;

public class RetrieveApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		JobSeerker js = null;

		File imagef = new File("D:\\JavaEE\\Hibernate\\HBLobOperation\\src\\store\\photo.jpg");
		File resumef = new File("D:\\JavaEE\\Hibernate\\HBLobOperation\\src\\store\\resume.txt");

		try {
			session = HiberbateUtil.getSession();
			if (session != null) {
				js = session.get(JobSeerker.class, 1);
				if (js != null) {
					try (FileOutputStream fos = new FileOutputStream(imagef)) {
						fos.write(js.getPhoto());
						fos.flush();
					}
					try (FileWriter fw = new FileWriter(resumef)) {
						fw.write(js.getResume());
						fw.flush();
					}
				}
				System.out.println(js);
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
