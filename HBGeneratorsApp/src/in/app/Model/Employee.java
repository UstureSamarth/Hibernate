package in.app.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee")
public class Employee {

	/*
	 * @Id
	 * 
	 * @Column(name = "eid")
	 * 
	 * @GenericGenerator(name = "gen1", strategy = "assigned")
	 * 
	 * @GeneratedValue(generator = "gen1") private Integer empId;
	 */

	/*
	 * @Id
	 * 
	 * @Column(name = "eid")
	 * 
	 * @GenericGenerator(name = "gen1", strategy = "increment")
	 * 
	 * @GeneratedValue(generator = "gen1") private Integer empId;
	 */

	@Id
	@Column(name = "eid")
	@GenericGenerator(name = "gen1", strategy = "identity")
	@GeneratedValue(generator = "gen1")
	private Integer empId;

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
