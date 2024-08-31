package in.app.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

import in.app.Model.InsurancePolicy;
import in.app.util.HiberbateUtil;

/*CREATE DEFINER=`root`@`localhost` PROCEDURE `get_policies_by_tenure`(in tenure1 INT,in tenure2 INT)
BEGIN
	select policyId,company,policyName,policyType,tenure from hibernate.insurance_policy where tenure>=tenure1 and tenure<=tenure2;
END*/
public class InsurancePolicyImpl implements IInsurancePolicy {

	@Override
	public List<InsurancePolicy> getPoliciesByTenure(Integer start, Integer end) {
		Session session = HiberbateUtil.getSession();
		ProcedureCall pc = session.createStoredProcedureCall("get_policies_by_tenure", InsurancePolicy.class);
		pc.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(start);
		pc.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(end);

		List<InsurancePolicy> l = pc.getResultList();
		return l;
	}

	@Override
	public String[] getPolicyById(Integer id) {
		Session session = HiberbateUtil.getSession();
		ProcedureCall pc = session.createStoredProcedureCall("get_policy_by_id");
		pc.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(id);
		pc.registerParameter(2, Long.class, ParameterMode.OUT);
		pc.registerParameter(3, String.class, ParameterMode.OUT);
		pc.execute();
		Long pId = (Long) pc.getOutputParameterValue(2);
		String pName = (String) pc.getOutputParameterValue(3);
		String result[] = { pId.toString(), pName };
		return result;
	}

}
