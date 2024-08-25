package someidea.xepdb.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "AUTH_PAGE")
@Data
public class AuthPageEntity {
/*
 * UUID
PAGE_ID
PARENT_ID
PAGE_URL
ICON_URL
SORT_NO
ENABLE
CREATE_USER
CREATE_DATE
UPDATE_USER
UPDATE_DATE
REMARK
 * 
 * */
	@Id
	@Column(name="UUID")
	private String uuid;
	
	@Column(name = "PAGE_ID")
	private String pageId;
	
	@Column(name = "PARENT_ID")
	private String parentId;
	
	@Column(name = "PAGE_URL")
	private String pageUrl;
	
	@Column(name="ICON_URL")
	private String iconUrl;
	
	@Column(name = "SORT_NO")
	private BigDecimal sortNo;
	
	@Column(name = "ENABLE")
	private String enable;
	
	@Column(name="CREATE_USER")
	private String createUser;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="UPDATE_USER")
	private String updateUser;
	
	@Column(name="UPDATE_DATE")
	private Date updateDate;
	
	@Column(name="REMARK")
	private String remark;
}
