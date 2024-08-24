package in.app.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProjectInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "pid")
	private Integer pid;

	@Column(name = "pgmid")
	private Integer programmerId;

	public ProjectInfo() {

	}

	public ProjectInfo(Integer pid, Integer programmerId) {
		super();
		this.pid = pid;
		this.programmerId = programmerId;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getProgrammerId() {
		return programmerId;
	}

	public void setProgrammerId(Integer programmerId) {
		this.programmerId = programmerId;
	}

	@Override
	public String toString() {
		return "ProjectInfo [pid=" + pid + ", programmerId=" + programmerId + "]";
	}

}
