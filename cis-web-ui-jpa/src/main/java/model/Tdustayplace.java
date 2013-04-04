package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tdustayplace database table.
 * 
 */
@Entity
public class Tdustayplace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp cdate;

	private int cidcisuser;

	@Temporal(TemporalType.DATE)
	private Date datefrom;

	@Temporal(TemporalType.DATE)
	private Date dateto;

	private Timestamp ddate;

	private int didcisuser;

	private int idaddress;

	private int idorgunit;

	private int idperson;

	@Column(name="idperson_original")
	private int idpersonOriginal;

	private int idtdustay;

	private String note;

	private int rstatus;

	private Timestamp udate;

	private int uidcisuser;

	public Tdustayplace() {
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

	public Date getDatefrom() {
		return this.datefrom;
	}

	public void setDatefrom(Date datefrom) {
		this.datefrom = datefrom;
	}

	public Date getDateto() {
		return this.dateto;
	}

	public void setDateto(Date dateto) {
		this.dateto = dateto;
	}

	public Timestamp getDdate() {
		return this.ddate;
	}

	public void setDdate(Timestamp ddate) {
		this.ddate = ddate;
	}

	public int getDidcisuser() {
		return this.didcisuser;
	}

	public void setDidcisuser(int didcisuser) {
		this.didcisuser = didcisuser;
	}

	public int getIdaddress() {
		return this.idaddress;
	}

	public void setIdaddress(int idaddress) {
		this.idaddress = idaddress;
	}

	public int getIdorgunit() {
		return this.idorgunit;
	}

	public void setIdorgunit(int idorgunit) {
		this.idorgunit = idorgunit;
	}

	public int getIdperson() {
		return this.idperson;
	}

	public void setIdperson(int idperson) {
		this.idperson = idperson;
	}

	public int getIdpersonOriginal() {
		return this.idpersonOriginal;
	}

	public void setIdpersonOriginal(int idpersonOriginal) {
		this.idpersonOriginal = idpersonOriginal;
	}

	public int getIdtdustay() {
		return this.idtdustay;
	}

	public void setIdtdustay(int idtdustay) {
		this.idtdustay = idtdustay;
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