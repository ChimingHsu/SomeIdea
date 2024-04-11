package someidea.xepdb.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import someidea.xepdb.entity.id.AuthUserGroupId;

@Entity
@Table(name = "AUTH_USER_GROUP")
@IdClass(AuthUserGroupId.class)
public class AuthUserGroupEntity {
	@Id
	@Column(name = "USER_NAME") private String userName;
	@Id
	@Column(name = "GROUP_NAME") private String groupName;
	@Column(name = "CREATE_USER") private String createUser;
	@Column(name = "CREATE_DATE") private Date createDate;
	@Column(name = "UPDATE_USER") private String updateUser;
	@Column(name = "UPDATE_DATE") private Date updateDate;

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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
