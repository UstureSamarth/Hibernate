package in.app.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "mobile_customer")
public class MobileCustomer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cust_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cno;

	@Column(length = 20)
	private String cname;

	private Long mobileNo;

	@Column(length = 40)
	private String callerTune;

	@Version
	private Integer versionCount;

	public MobileCustomer() {

	}

	public MobileCustomer(String cname, Long mobileNo, String callerTune) {
		super();
		this.cname = cname;
		this.mobileNo = mobileNo;
		this.callerTune = callerTune;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCallerTune() {
		return callerTune;
	}

	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}

	public Integer getVersionCount() {
		return versionCount;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}

	@Override
	public String toString() {
		return "MobileCustomer [cname=" + cname + ", mobileNo=" + mobileNo + ", callerTune=" + callerTune
				+ ", versionCount=" + versionCount + "]";
	}

}
