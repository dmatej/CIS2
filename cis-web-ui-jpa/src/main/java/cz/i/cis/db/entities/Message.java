package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	private Timestamp cdate;

	private int cidcisuser;

	@Id
	private int id;

	private String text;

	private String type;

	private Timestamp validfrom;

	private Timestamp validto;

	public Message() {
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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