package someidea.xepdb.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "AUTH_USER")
@Data
public class AuthUserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID") 
	private BigDecimal id;
	
	@Column(name = "USER_NAME") 
	@NotEmpty(message = "User Name Can Not Be Empty")
	private String userName;
	
	@Column(name = "PASSWORD")
	@NotEmpty(message = "Password Can Not Be Empty")
	private String password;
	
	@Column(name = "EMAIL")
	@NotEmpty(message = "Email Can Not Be Empty")
	private String email;
	
	@Column(name = "LAST_LOGIN_DATE") 
	private Date lastLoginDate;
	
	@Column(name = "LAST_CHG_PSW_DATE") 
	private Date lastChgPswDate;
	
	@Column(name = "PSW_EXPIRY_DAYS") 
	private BigDecimal pswExpiryDays;
	
	@Column(name = "ACCOUNT_EXPIRY_DAYS") 
	private BigDecimal accountExpiryDays;
	
	@Column(name = "ENABLED") 
	private String enabled;
	
	@Column(name = "LOCKED") 
	private String locked;
	
	@Column(name = "CREATE_DATE") 
	private Date createDate;
	
	@Column(name = "UPDATE_DATE") 
	private Date updateDate;
}
