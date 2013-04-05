package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the password database table.
 * 
 */
@Entity
public class Password implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String algorithm;

	private Timestamp cdate;

	private int cidcisuser;

	private Timestamp ddate;

	private int didcisuser;

	private int idcisuser;

	private String password;

	@Temporal(TemporalType.DATE)
	private Date validfrom;

	@Temporal(TemporalType.DATE)
	private Date validto;

	public Password() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlgorithm() {
		return this.algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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