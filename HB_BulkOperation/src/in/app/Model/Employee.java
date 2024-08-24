package in.app.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_tab_bulk")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eNo;

	@Column(length = 20)
	private String eName;

	@Column(length = 50)
	private String eAddr;

	private Integer eSal;

	public Long geteNo() {
		return eNo;
	}

	public void seteNo(Long eNo) {
		System.out.println("Employee.seteNo()");
		this.eNo = eNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		System.out.println("Employee.seteName()");
		this.eName = eName;
	}

	public String geteAddr() {
		return eAddr;
	}

	public void seteAddr(String eAddr) {
		System.out.println("Employee.seteAddr()");
		this.eAddr = eAddr;
	}

	public Integer geteSal() {
		return eSal;
	}

	public void seteSal(Integer eSal) {
		System.out.println("Employee.seteSal()");
		this.eSal = eSal;
	}

	@Override
	public String toString() {
		return "Employee [eNo=" + eNo + ", eName=" + eName + ", eAddr=" + eAddr + ", eSal=" + eSal + "]";
	}

}
