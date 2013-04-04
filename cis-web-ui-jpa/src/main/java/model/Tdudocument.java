package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tdudocument database table.
 * 
 */
@Entity
public class Tdudocument implements Serializable {
	private static final long serialVersionUID = 1L;

	private Timestamp cdate;

	private int cidcisuser;

	@Temporal(TemporalType.DATE)
	private Date dateofcancel;

	@Temporal(TemporalType.DATE)
	private Date dateofreceipt;

	@Temporal(TemporalType.DATE)
	private Date dateofrenewal;

	private Timestamp ddate;

	private int didcisuser;

	@Id
	private int id;

	private int idcisuser;

	private int idcodedocumenttype;

	private int ididentity;

	private int idorgunitissued;

	private int idperson;

	@Column(name="idperson_original")
	private int idpersonOriginal;

	private int idstateissued;

	private int idtdustay;

	@Temporal(TemporalType.DATE)
	private Date issued;

	private String note;

	private String number;

	private int rstatus;

	private Timestamp udate;

	private int uidcisuser;

	@Temporal(TemporalType.DATE)
	private Date validfrom;

	@Temporal(TemporalType.DATE)
	private Date validto;

	private String visaapplicationnumber;

	public Tdudocument() {
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

	public Date getDateofcancel() {
		return this.dateofcancel;
	}

	public void setDateofcancel(Date dateofcancel) {
		this.dateofcancel = dateofcancel;
	}

	public Date getDateofreceipt() {
		return this.dateofreceipt;
	}

	public void setDateofreceipt(Date dateofreceipt) {
		this.dateofreceipt = dateofreceipt;
	}

	public Date getDateofrenewal() {
		return this.dateofrenewal;
	}

	public void setDateofrenewal(Date dateofrenewal) {
		this.dateofrenewal = dateofrenewal;
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdcisuser() {
		return this.idcisuser;
	}

	public void setIdcisuser(int idcisuser) {
		this.idcisuser = idcisuser;
	}

	public int getIdcodedocumenttype() {
		return this.idcodedocumenttype;
	}

	public void setIdcodedocumenttype(int idcodedocumenttype) {
		this.idcodedocumenttype = idcodedocumenttype;
	}

	public int getIdidentity() {
		return this.ididentity;
	}

	public void setIdidentity(int ididentity) {
		this.ididentity = ididentity;
	}

	public int getIdorgunitissued() {
		return this.idorgunitissued;
	}

	public void setIdorgunitissued(int idorgunitissued) {
		this.idorgunitissued = idorgunitissued;
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

	public int getIdstateissued() {
		return this.idstateissued;
	}

	public void setIdstateissued(int idstateissued) {
		this.idstateissued = idstateissued;
	}

	public int getIdtdustay() {
		return this.idtdustay;
	}

	public void setIdtdustay(int idtdustay) {
		this.idtdustay = idtdustay;
	}

	public Date getIssued() {
		return this.issued;
	}

	public void setIssued(Date issued) {
		this.issued = issued;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public Date getValidfrom() {
		return this.validfrom;
	}

	public void setValidfrom(Date validfrom) {
		this.validfrom = validfrom;
	}

	public Date getValidto() {
		return this.validto;
	}

	public void setValidto(Date validto) {
		this.validto = validto;
	}

	public String getVisaapplicationnumber() {
		return this.visaapplicationnumber;
	}

	public void setVisaapplicationnumber(String visaapplicationnumber) {
		this.visaapplicationnumber = visaapplicationnumber;
	}

}