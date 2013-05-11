package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the cisuserrole database table.
 *
 */
@Entity
public class Cisuserrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp cdate;

	private Integer cidcisuser;

	private Timestamp ddate;

	private Integer didcisuser;

	private Integer idcisuser;

	private Integer idrole;

	@Temporal(TemporalType.DATE)
	private Date validfrom;

	@Temporal(TemporalType.DATE)
	private Date validto;

	public Cisuserrole() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getDidcisuser() {
		return this.didcisuser;
	}

	public void setDidcisuser(Integer didcisuser) {
		this.didcisuser = didcisuser;
	}

	public Integer getIdcisuser() {
		return this.idcisuser;
	}

	public void setIdcisuser(Integer idcisuser) {
		this.idcisuser = idcisuser;
	}

	public Integer getIdrole() {
		return this.idrole;
	}

	public void setIdrole(Integer idrole) {
		this.idrole = idrole;
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