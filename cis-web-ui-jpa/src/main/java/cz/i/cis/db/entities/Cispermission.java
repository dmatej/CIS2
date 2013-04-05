package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cispermission database table.
 * 
 */
@Entity
public class Cispermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String annotation;

	private Timestamp cdate;

	private int cidcisuser;

	private String code;

	private Timestamp ddate;

	private String description;

	private int didcisuser;

	private String name;

	private Timestamp udate;

	private int uidcisuser;

	private Timestamp validfrom;

	private Timestamp validto;

	public Cispermission() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnnotation() {
		return this.annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
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

	public int getDidcisuser() {
		return this.didcisuser;
	}

	public void setDidcisuser(int didcisuser) {
		this.didcisuser = didcisuser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Timestamp getValidfrom() {
		return this.validfrom;
	}

	public void setValidfrom(Timestamp validfrom) {
		this.validfrom = validfrom;
	}

	public Timestamp getValidto() {
		return this.validto;
	}

	public void setValidto(Timestamp validto) {
		this.validto = validto;
	}

}