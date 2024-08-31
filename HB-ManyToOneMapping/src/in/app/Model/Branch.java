package in.app.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branchone")
public class Branch {

	@Id
	private Integer bid;
	private String bName;
	private String bLocation;

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Branch(Integer bid, String bName, String bLocation) {
		super();
		this.bid = bid;
		this.bName = bName;
		this.bLocation = bLocation;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbLocation() {
		return bLocation;
	}

	public void setbLocation(String bLocation) {
		this.bLocation = bLocation;
	}

	@Override
	public String toString() {
		return "Branch [bid=" + bid + ", bName=" + bName + ", bLocation=" + bLocation + "]";
	}

}
