package in.app.main;

import in.app.dao.IInsurancePolicy;
import in.app.dao.InsurancePolicyImpl;

public class InsertRecordsApp {
	public static void main(String[] args) {
		IInsurancePolicy ip = null;
		ip = new InsurancePolicyImpl();
		String result = ip.transferPremeiumPolicies(10);
		System.out.println(result);
	}
}
