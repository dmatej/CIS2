package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tduperson database table.
 * 
 */
@Entity
public class Tduperson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp cdate;

	private int cidcisuser;

	private Timestamp ddate;

	@Temporal(TemporalType.DATE)
	private Date deathdate;

	private String deathplace;

	private String degreeprefix;

	private String degreesuffix;

	private int didcisuser;

	private int idcisuser;

	private int iddeathplace;

	private int iddeathstate;

	@Column(name="ididentity_actual")
	private int ididentityActual;

	private int idimage;

	@Column(name="idperson_original")
	private int idpersonOriginal;

	@Column(name="idstay_actual")
	private int idstayActual;

	@Column(name="idstayplace_actual")
	private int idstayplaceActual;

	private String note;

	private int rstatus;

	private String sex;

	private Timestamp udate;

	private int uidcisuser;

	public Tduperson() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCdate() {
		return this.cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}

	public int getCidcisuser() {
		return this.cidcisuser;
	}

	public void setCidcisuser(int cidcisuser) {
		this.cidcisuser = cidcisuser;
	}

	public Timestamp getDdate() {
		return this.ddate;
	}

	public void setDdate(Timestamp ddate) {
		this.ddate = ddate;
	}

	public Date getDeathdate() {
		return this.deathdate;
	}

	public void setDeathdate(Date deathdate) {
		this.deathdate = deathdate;
	}

	public String getDeathplace() {
		return this.deathplace;
	}

	public void setDeathplace(String deathplace) {
		this.deathplace = deathplace;
	}

	public String getDegreeprefix() {
		return this.degreeprefix;
	}

	public void setDegreeprefix(String degreeprefix) {
		this.degreeprefix = degreeprefix;
	}

	public String getDegreesuffix() {
		return this.degreesuffix;
	}

	public void setDegreesuffix(String degreesuffix) {
		this.degreesuffix = degreesuffix;
	}

	public int getDidcisuser() {
		return this.didcisuser;
	}

	public void setDidcisuser(int didcisuser) {
		this.didcisuser = didcisuser;
	}

	public int getIdcisuser() {
		return this.idcisuser;
	}

	public void setIdcisuser(int idcisuser) {
		this.idcisuser = idcisuser;
	}

	public int getIddeathplace() {
		return this.iddeathplace;
	}

	public void setIddeathplace(int iddeathplace) {
		this.iddeathplace = iddeathplace;
	}

	public int getIddeathstate() {
		return this.iddeathstate;
	}

	public void setIddeathstate(int iddeathstate) {
		this.iddeathstate = iddeathstate;
	}

	public int getIdidentityActual() {
		return this.ididentityActual;
	}

	public void setIdidentityActual(int ididentityActual) {
		this.ididentityActual = ididentityActual;
	}

	public int getIdimage() {
		return this.idimage;
	}

	public void setIdimage(int idimage) {
		this.idimage = idimage;
	}

	public int getIdpersonOriginal() {
		return this.idpersonOriginal;
	}

	public void setIdpersonOriginal(int idpersonOriginal) {
		this.idpersonOriginal = idpersonOriginal;
	}

	public int getIdstayActual() {
		return this.idstayActual;
	}

	public void setIdstayActual(int idstayActual) {
		this.idstayActual = idstayActual;
	}

	public int getIdstayplaceActual() {
		return this.idstayplaceActual;
	}

	public void setIdstayplaceActual(int idstayplaceActual) {
		this.idstayplaceActual = idstayplaceActual;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getRstatus() {
		return this.rstatus;
	}

	public void setRstatus(int rstatus) {
		this.rstatus = rstatus;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getUdate() {
		return this.udate;
	}

	public void setUdate(Timestamp udate) {
		this.udate = udate;
	}

	public int getUidcisuser() {
		return this.uidcisuser;
	}

	public void setUidcisuser(int uidcisuser) {
		this.uidcisuser = uidcisuser;
	}

}