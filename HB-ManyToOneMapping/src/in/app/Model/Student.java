package in.app.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studentmany")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;

	private String sname;

	@ManyToOne(cascade = CascadeType.ALL)
	private Branch branch;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String sname, Branch branch) {
		super();
		this.sname = sname;
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", branch=" + branch + "]";
	}

}
