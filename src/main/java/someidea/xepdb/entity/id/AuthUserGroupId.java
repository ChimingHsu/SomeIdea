package someidea.xepdb.entity.id;

import java.math.BigDecimal;
import java.util.Objects;

public class AuthUserGroupId {
	private BigDecimal userId;
	private BigDecimal groupId;
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
	@Override
	public int hashCode() {
		return Objects.hash(groupId, userId);
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
		return Objects.equals(groupId, other.groupId) && Objects.equals(userId, other.userId);
	}
}
