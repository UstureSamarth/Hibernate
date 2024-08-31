package in.app.dao;

import java.util.List;
import in.app.Model.*;

public interface IInsurancePolicy {
	List<InsurancePolicy> getPoliciesByTenure(Integer start, Integer end);

	String[] getPolicyById(Integer id);
}
