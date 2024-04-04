package someidea.db.mes.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "EMS_CR_EQP")
@Entity
public class EmsCrEqpEntity {
	
	@Id
	@Column(name="APPLYNO")
	private String applyNo;
	
	@Column(name="EQPID")
	private String eqptId;
	
	@Column(name="TRANSUSER")
	private String transUser;
	
	@Column(name="TRANSDATE")
	private Date transDate;
	
	@Column(name="UUSER")
	private String uUser;
	
	@Column(name="UDATE")
	private Date uDate;
	public String getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}
	public String getEqptId() {
		return eqptId;
	}
	public void setEqptId(String eqptId) {
		this.eqptId = eqptId;
	}
	public String getTransUser() {
		return transUser;
	}
	public void setTransUser(String transUser) {
		this.transUser = transUser;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getuUser() {
		return uUser;
	}
	public void setuUser(String uUser) {
		this.uUser = uUser;
	}
	public Date getuDate() {
		return uDate;
	}
	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}
}
