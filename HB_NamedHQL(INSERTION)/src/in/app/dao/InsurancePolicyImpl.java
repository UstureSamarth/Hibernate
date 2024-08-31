package in.app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.app.util.HiberbateUtil;

public class InsurancePolicyImpl implements IInsurancePolicy {

	@Override
	public String transferPremeiumPolicies(int maxTenure) {
		Session session = null;
		session = HiberbateUtil.getSession();
		Transaction transaction = null;
		Integer count = 0;
		Boolean flag = false;
		String msg = null;
		try {
			if (session != null) {
				transaction = session.beginTransaction();
				Query query = session.getNamedQuery("HQL_INSERT_TRANSFER_POLICIES");
				query.setParameter("tenure", maxTenure);
				count = query.executeUpdate();
				if (count > 0)
					flag = true;

			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				msg = "No of records transfered are " + count;
			} else {
				transaction.rollback();
			}
			HiberbateUtil.closeSession();
		}

		return msg;
	}

	/*
	 * public String transferPremeiumPolicies2(int maxTenure) { Session session =
	 * null; session = HiberbateUtil.getSession(); Transaction transaction = null;
	 * Integer count = 0; Boolean flag = false; String msg = null; try { if (session
	 * != null) { transaction = session.beginTransaction(); Query query =
	 * session.getNamedQuery("HQL_TRANSFER_QUERY"); query.setParameter("tenure",
	 * maxTenure); count = query.executeUpdate(); if (count > 0) flag = true;
	 * 
	 * } } catch (HibernateException he) { he.printStackTrace(); } catch (Exception
	 * e) { e.printStackTrace(); } finally { if (flag) { transaction.commit(); msg =
	 * "No of records transfered are " + count; } else { transaction.rollback(); }
	 * HiberbateUtil.closeSession(); }
	 * 
	 * return msg; }
	 */

}
