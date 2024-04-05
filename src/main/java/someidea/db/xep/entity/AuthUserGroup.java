package someidea.db.xep.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AUTH_USER_GROUP")
public class AuthUserGroup {
	@Id
	@Column(name = "USER_ID") private BigDecimal userId;
	@Column(name = "GROUP_ID") private BigDecimal groupId;
	@Column(name = "CREATE_USER") private String createUser;
	@Column(name = "CREATE_DATE") private Date createDate;
	@Column(name = "UPDATE_USER") private String updateUser;
	@Column(name = "UPDATE_DATE") private Date updateDate;
	public BigDecimal getUserId() {
		return userId;
	}
	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}
	public BigDecimal getGroupId() {
		return groupId;
	}
	public void setGroupId(BigDecimal groupId) {
		this.groupId = groupId;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
