package in.app.main;

import java.util.List;

import in.app.Model.InsurancePolicy;
import in.app.dao.IInsurancePolicy;
import in.app.dao.InsurancePolicyImpl;

public class TestApp {

	public static void main(String[] args) {
		IInsurancePolicy ip = null;
		ip = new InsurancePolicyImpl();
		List<InsurancePolicy> l = ip.getPoliciesByTenure(10, 30);
		l.forEach(System.out::println);
		String s[]=ip.getPolicyById(1);
		System.out.println(s[0]+" "+s[1]);

	}

}
