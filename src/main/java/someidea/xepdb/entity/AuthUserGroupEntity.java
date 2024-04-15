package someidea.xepdb.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import someidea.xepdb.entity.id.AuthUserGroupId;

@Entity
@Table(name = "AUTH_USER_GROUP")
@IdClass(AuthUserGroupId.class)
@Data
public class AuthUserGroupEntity {
	@Id
	@Column(name = "USER_NAME") 
	@NotEmpty(message = "User Name is mandatory")
	private String userName;
	
	@Id
	@Column(name = "GROUP_NAME")
	@NotEmpty(message = "Group Name is mandatory")
	private String groupName;
	
	@Column(name = "CREATE_USER") 
	private String createUser;
	
	@Column(name = "CREATE_DATE") 
	private Date createDate;
	
	@Column(name = "UPDATE_USER") 
	private String updateUser;
	
	@Column(name = "UPDATE_DATE") 
	private Date updateDate;
}
