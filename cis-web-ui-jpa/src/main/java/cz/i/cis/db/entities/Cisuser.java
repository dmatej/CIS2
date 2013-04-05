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
	private int id;

	private short badlogincount;

	private int blocked;

	private Timestamp cdate;

	private int cidcisuser;

	private Timestamp ddate;

	private String degreeprefix;

	private String degreesuffix;

	private int didcisuser;

	private int forcepwdchange;

	private int idorgunit;

	private String info;

	private Timestamp lastbadlogin;

	private Timestamp lastlogin;

	private String name;

	private String surname;

	private Timestamp udate;

	private String uid;

	private int uidcisuser;

	@Temporal(TemporalType.DATE)
	private Date validfrom;

	@Temporal(TemporalType.DATE)
	private Date validto;

	public Cisuser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getBadlogincount() {
		return this.badlogincount;
	}

	public void setBadlogincount(short badlogincount) {
		this.badlogincount = badlogincount;
	}

	public int getBlocked() {
		return this.blocked;
	}

	public void setBlocked(int blocked) {
		this.blocked = blocked;
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

	public int getForcepwdchange() {
		return this.forcepwdchange;
	}

	public void setForcepwdchange(int forcepwdchange) {
		this.forcepwdchange = forcepwdchange;
	}

	public int getIdorgunit() {
		return this.idorgunit;
	}

	public void setIdorgunit(int idorgunit) {
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

}