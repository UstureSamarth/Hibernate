package in.app.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "empTab2")
public class Employee {

	@Id
	@Column(name = "eid")
	@GeneratedValue(generator = "gen1")
	@GenericGenerator(name = "gen1", strategy = "in.app.generator.CustomGenerator")
	private Integer empId;

	@Column(name = "ename", length = 15)
	private String empName;

	@Column(name = "esal")
	private double empSal;

	public Employee() {
	}

	public Employee(String empName, double empSal) {
		super();
		this.empName = empName;
		this.empSal = empSal;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

}
