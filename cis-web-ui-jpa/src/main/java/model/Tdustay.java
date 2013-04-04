package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tdustay database table.
 * 
 */
@Entity
public class Tdustay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date arrivaldate;

	private Timestamp cdate;

	private int cidcisuser;

	@Temporal(TemporalType.DATE)
	private Date datefrom;

	private Timestamp ddate;

	private int didcisuser;

	@Temporal(TemporalType.DATE)
	private Date grantedfrom;

	@Temporal(TemporalType.DATE)
	private Date grantedto;

	private int idorgunit;

	private int idorgunituziv;

	private int idperson;

	@Column(name="idperson_original")
	private int idpersonOriginal;

	private int idpobytucel;

	private String note;

	private String pkp;

	private String refnumber;

	private int rstatus;

	@Temporal(TemporalType.DATE)
	private Date terminationdate;

	private Timestamp udate;

	private int uidcisuser;

	private String visaapplicationnumber;

	public Tdustay() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getArrivaldate() {
		return this.arrivaldate;
	}

	public void setArrivaldate(Date arrivaldate) {
		this.arrivaldate = arrivaldate;
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

	public Date getGrantedfrom() {
		return this.grantedfrom;
	}

	public void setGrantedfrom(Date grantedfrom) {
		this.grantedfrom = grantedfrom;
	}

	public Date getGrantedto() {
		return this.grantedto;
	}

	public void setGrantedto(Date grantedto) {
		this.grantedto = grantedto;
	}

	public int getIdorgunit() {
		return this.idorgunit;
	}

	public void setIdorgunit(int idorgunit) {
		this.idorgunit = idorgunit;
	}

	public int getIdorgunituziv() {
		return this.idorgunituziv;
	}

	public void setIdorgunituziv(int idorgunituziv) {
		this.idorgunituziv = idorgunituziv;
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

	public int getIdpobytucel() {
		return this.idpobytucel;
	}

	public void setIdpobytucel(int idpobytucel) {
		this.idpobytucel = idpobytucel;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPkp() {
		return this.pkp;
	}

	public void setPkp(String pkp) {
		this.pkp = pkp;
	}

	public String getRefnumber() {
		return this.refnumber;
	}

	public void setRefnumber(String refnumber) {
		this.refnumber = refnumber;
	}

	public int getRstatus() {
		return this.rstatus;
	}

	public void setRstatus(int rstatus) {
		this.rstatus = rstatus;
	}

	public Date getTerminationdate() {
		return this.terminationdate;
	}

	public void setTerminationdate(Date terminationdate) {
		this.terminationdate = terminationdate;
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

	public String getVisaapplicationnumber() {
		return this.visaapplicationnumber;
	}

	public void setVisaapplicationnumber(String visaapplicationnumber) {
		this.visaapplicationnumber = visaapplicationnumber;
	}

}