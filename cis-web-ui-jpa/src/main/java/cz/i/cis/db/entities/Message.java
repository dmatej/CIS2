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

	private Integer cidcisuser;

	@Id
	private Integer id;

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

	public Integer getCidcisuser() {
		return this.cidcisuser;
	}

	public void setCidcisuser(Integer cidcisuser) {
		this.cidcisuser = cidcisuser;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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