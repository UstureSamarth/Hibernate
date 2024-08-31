package in.app.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {
	@Id
	private Long pid;

	private String pName;
	private String company;
	private String location;
	private Integer teamSize;
	private float cost;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pName=" + pName + ", company=" + company + ", location=" + location
				+ ", teamSize=" + teamSize + ", cost=" + cost + "]";
	}

}
