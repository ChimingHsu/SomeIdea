package garyhsu.springboot.entity.mesdb;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADM_GROUP")
public class AdmGroupEntity {
	
	@Id
	@Column(name = "GROUP_ID")
	private String groupId;
	
	@Column(name = "GROUP_NAME")
	private String groupName;
	
	@Column(name = "SITE")
	private String site;
	
	@Column(name = "WEB_GROUP")
	private String webGroup;
	
	@Column(name = "CDATE")
	private Date cdate;
	
	@Column(name = "CUSER")
	private String cuser;
	
	@Column(name = "UDATE")
	private Date udate;
	
	@Column(name = "UUSER")
	private String uuser;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getWebGroup() {
		return webGroup;
	}

	public void setWebGroup(String webGroup) {
		this.webGroup = webGroup;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCuser() {
		return cuser;
	}

	public void setCuser(String cuser) {
		this.cuser = cuser;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public String getUuser() {
		return uuser;
	}

	public void setUuser(String uuser) {
		this.uuser = uuser;
	}
	
}
