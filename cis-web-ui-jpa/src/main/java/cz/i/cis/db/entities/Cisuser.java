package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the cisuser database table.
 *
 */
@Entity
public class Cisuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Short badlogincount;

	private Integer blocked;

	private Timestamp cdate;

	private Integer cidcisuser;

	private Timestamp ddate;

	private String degreeprefix;

	private String degreesuffix;

	private Integer didcisuser;

	private Integer forcepwdchange;

	private Integer idorgunit;

	private String info;

	private Timestamp lastbadlogin;

	private Timestamp lastlogin;

	private String name;

	private String surname;

	private Timestamp udate;

	private String uid;

	private Integer uidcisuser;

	@Temporal(TemporalType.DATE)
	private Date validfrom;

	@Temporal(TemporalType.DATE)
	private Date validto;

	public Cisuser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getBadlogincount() {
		return this.badlogincount;
	}

	public void setBadlogincount(Short badlogincount) {
		this.badlogincount = badlogincount;
	}

	public Integer getBlocked() {
		return this.blocked;
	}

	public void setBlocked(Integer blocked) {
		this.blocked = blocked;
	}

	public Timestamp getCdate() {
		return this.cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}

	public Integer getCidcisuser() {
		return this.cidcisuser;
	}

	public void setCidcisuser(Integer cidcisuser) {
		this.cidcisuser = cidcisuser;
	}

	public Timestamp getDdate() {
		return this.ddate;
	}

	public void setDdate(Timestamp ddate) {
		this.ddate = ddate;
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

	public Integer getDidcisuser() {
		return this.didcisuser;
	}

	public void setDidcisuser(Integer didcisuser) {
		this.didcisuser = didcisuser;
	}

	public Integer getForcepwdchange() {
		return this.forcepwdchange;
	}

	public void setForcepwdchange(Integer forcepwdchange) {
		this.forcepwdchange = forcepwdchange;
	}

	public Integer getIdorgunit() {
		return this.idorgunit;
	}

	public void setIdorgunit(Integer idorgunit) {
		this.idorgunit = idorgunit;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Timestamp getLastbadlogin() {
		return this.lastbadlogin;
	}

	public void setLastbadlogin(Timestamp lastbadlogin) {
		this.lastbadlogin = lastbadlogin;
	}

	public Timestamp getLastlogin() {
		return this.lastlogin;
	}

	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Timestamp getUdate() {
		return this.udate;
	}

	public void setUdate(Timestamp udate) {
		this.udate = udate;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getUidcisuser() {
		return this.uidcisuser;
	}

	public void setUidcisuser(Integer uidcisuser) {
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

}