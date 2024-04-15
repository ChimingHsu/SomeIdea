package someidea.xepdb.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "AUTH_GROUP")
@Data
public class AuthGroupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID") private BigDecimal id;
	@Column(name = "GROUP_NAME") private String groupName;
	@Column(name = "CREATE_USER") private String createUser;
	@Column(name = "CREATE_DATE") private Date createDate;
	@Column(name = "UPDATE_USER") private String updateUser;
	@Column(name = "UPDATE_DATE") private Date updateDate;
	@Column(name = "DESCRIPTION") private String description;
	
}
