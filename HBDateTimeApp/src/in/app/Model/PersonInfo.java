package in.app.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_info")
public class PersonInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private Integer pid;

	@Column(name = "pname", length = 20)
	private String pname;

	@Column(name = "paddress", length = 3)
	private String paddress;

	private LocalDate dob;

	private LocalDateTime doj;

	private LocalTime dom;

	public PersonInfo() {
	}

	public PersonInfo(String pname, String paddress, LocalDate dob, LocalDateTime doj, LocalTime dom) {
		this.pname = pname;
		this.paddress = paddress;
		this.dob = dob;
		this.doj = doj;
		this.dom = dom;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDateTime getDoj() {
		return doj;
	}

	public void setDoj(LocalDateTime doj) {
		this.doj = doj;
	}

	public LocalTime getDom() {
		return dom;
	}

	public void setDom(LocalTime dom) {
		this.dom = dom;
	}

	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", dob=" + dob + ", doj="
				+ doj + ", dom=" + dom + "]";
	}

}
