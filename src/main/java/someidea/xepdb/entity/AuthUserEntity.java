package someidea.xepdb.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AUTH_USER")
public class AuthUserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID") private BigDecimal id;
	@Column(name = "USER_NAME") private String userName;
	@Column(name = "PASSWORD") private String password;
	@Column(name = "EMAIL") private String email;
	@Column(name = "LAST_LOGIN_DATE") private Date lastLoginDate;
	@Column(name = "LAST_CHG_PSW_DATE") private Date lastChgPswDate;
	@Column(name = "PSW_EXPIRY_DAYS") private BigDecimal pswExpiryDays;
	@Column(name = "ACCOUNT_EXPIRY_DAYS") private BigDecimal accountExpiryDays;
	@Column(name = "ENABLED") private String enabled;
	@Column(name = "LOCKED") private String locked;
	@Column(name = "CREATE_DATE") private Date createDate;
	@Column(name = "UPDATE_DATE") private Date updateDate;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public Date getLastChgPswDate() {
		return lastChgPswDate;
	}
	public void setLastChgPswDate(Date lastChgPswDate) {
		this.lastChgPswDate = lastChgPswDate;
	}
	public BigDecimal getPswExpiryDays() {
		return pswExpiryDays;
	}
	public void setPswExpiryDays(BigDecimal pswExpiryDays) {
		this.pswExpiryDays = pswExpiryDays;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public BigDecimal getAccountExpiryDays() {
		return accountExpiryDays;
	}
	public void setAccountExpiryDays(BigDecimal accountExpiryDays) {
		this.accountExpiryDays = accountExpiryDays;
	}
}
