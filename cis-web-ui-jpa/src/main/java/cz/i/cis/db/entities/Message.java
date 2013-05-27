package cz.i.cis.db.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the message database table.
 */
@Entity
public class Message implements Serializable {

  private static final long serialVersionUID = 1L;

  @Temporal(TemporalType.TIMESTAMP)
  private Date cdate;

  private Integer cidcisuser;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String text;

  private String type;

  @Temporal(TemporalType.DATE)
  private Date validfrom;

  @Temporal(TemporalType.DATE)
  private Date validto;


  public Message() {
  }


  public Date getCdate() {
    return this.cdate;
  }


  public void setCdate(Date cdate) {
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
