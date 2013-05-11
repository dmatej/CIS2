package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the cisrole database table.
 *
 */
@Entity
public class Cisrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Timestamp cdate;

	private Integer cidcisuser;

	private String code;

	private Timestamp ddate;

	private String description;

	private Integer didcisuser;

	private String name;

	private Short type;

	private Timestamp udate;

	private Integer uidcisuser;

	@Temporal(TemporalType.DATE)
	private Date validfrom;

	@Temporal(TemporalType.DATE)
	private Date validto;

	public Cisrole() {
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Timestamp getDdate() {
		return this.ddate;
	}

	public void setDdate(Timestamp ddate) {
		this.ddate = ddate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDidcisuser() {
		return this.didcisuser;
	}

	public void setDidcisuser(Integer didcisuser) {
		this.didcisuser = didcisuser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Timestamp getUdate() {
		return this.udate;
	}

	public void setUdate(Timestamp udate) {
		this.udate = udate;
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