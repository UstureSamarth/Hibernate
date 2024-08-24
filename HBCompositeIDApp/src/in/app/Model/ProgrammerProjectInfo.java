package in.app.Model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjectInfo {

	@EmbeddedId
	private ProjectInfo info;

	@Column(name = "pname", length = 20)
	private String programmerName;

	@Column(name = "deptNo")
	private Integer deptNo;

	@Column(name = "projname", length = 20)
	private String projectName;

	public ProgrammerProjectInfo() {
		super();
	}

	public ProgrammerProjectInfo(ProjectInfo info, String programmerName, Integer deptNo, String projectName) {
		super();
		this.info = info;
		this.programmerName = programmerName;
		this.deptNo = deptNo;
		this.projectName = projectName;
	}

	public String getProgrammerName() {
		return programmerName;
	}

	public void setProgrammerName(String programmerName) {
		this.programmerName = programmerName;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "ProgrammerProjectInfo [programmerName=" + programmerName + ", deptNo=" + deptNo + ", projectName="
				+ projectName + "]";
	}

}
