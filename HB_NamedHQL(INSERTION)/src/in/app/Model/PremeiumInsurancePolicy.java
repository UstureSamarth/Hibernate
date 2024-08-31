package in.app.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "premeium_insurance_policy")
@NamedQuery(name = "HQL_INSERT_TRANSFER_POLICIES",query = "insert into in.app.Model.PremeiumInsurancePolicy(policyId,policyName,policyType,company,tenure)  select i.policyId,i.policyName,i.policyType,i.company,i.tenure from in.app.Model.InsurancePolicy as i where i.tenure>=:tenure ")
public class PremeiumInsurancePolicy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;

	@Column(length = 30)
	private String policyName;

	@Column(length = 15)
	private String policyType;

	@Column(length = 20)
	private String company;

	private Integer tenure;

	public PremeiumInsurancePolicy() {

	}

	public PremeiumInsurancePolicy(String policyName, String policyType, String company, Integer tenure) {
		super();
		this.policyName = policyName;
		this.policyType = policyType;
		this.company = company;
		this.tenure = tenure;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}

}
