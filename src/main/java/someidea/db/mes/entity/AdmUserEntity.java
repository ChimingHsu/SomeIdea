package someidea.db.mes.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "ADM_USER")
public class AdmUserEntity {
	@Id
	@Column(name = "USER_NO")
	private String	userNo;
	
	@Column(name = "USER_NAME")
	private String	userName;
	
	@Column(name = "PASSWORD")
	private String	passwrod;
	
	@Column(name = "STATUS")
	private String	status;
	
	@Column(name = "SITE")
	private String	site;
	
	@Column(name = "PRODUCTION_LINE")
	private String	productionLine;
	
	@Column(name = "SHIFT")
	private String	shift;
	
	@Column(name = "CDATE")
	private Date	cdate;
	
	@Column(name = "CUSER")
	private String	cuser;
	
	@Column(name = "UDATE")
	private Date	udate;
	
	@Column(name = "UUSER")
	private String	uuser;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getProductionLine() {
		return productionLine;
	}

	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
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
