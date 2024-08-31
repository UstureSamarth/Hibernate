package in.app.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accone")
public class Account {

	@Id
	private Integer accNo;
	private String accName;
	private String accType;
	
	
	

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Integer accNo, String accName, String accType) {
		super();
		this.accNo = accNo;
		this.accName = accName;
		this.accType = accType;
	}

	public Integer getAccNo() {
		return accNo;
	}

	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accName=" + accName + ", accType=" + accType + "]";
	}

}
