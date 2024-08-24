package in.app.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	
	
	  @Id
	  
	  @Column(name = "eid")
	  
	  @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer empId;
	 
	
		/*
		 * @Id
		 * 
		 * @Column(name = "eid")
		 * 
		 * @GeneratedValue(strategy = GenerationType.AUTO) private Integer empId;
		 */

	@Column(name = "ename", length = 15)
	private String empName;

	@Column(name = "esal")
	private double empSal;

	static {
		System.out.println("Employee class is loading...");
	}

	public Employee() {
		System.out.println("Zero parameter constructor used by hibernate...");
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
