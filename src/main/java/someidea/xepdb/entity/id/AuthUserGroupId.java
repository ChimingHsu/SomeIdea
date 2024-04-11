package someidea.xepdb.entity.id;

import java.util.Objects;

public class AuthUserGroupId {
	private String userName;
	private String groupName;
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
	@Override
	public int hashCode() {
		return Objects.hash(groupName, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthUserGroupId other = (AuthUserGroupId) obj;
		return Objects.equals(groupName, other.groupName) && Objects.equals(userName, other.userName);
	}
}
