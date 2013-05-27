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
 * The persistent class for the cisrolepermission database table.
 */
@Entity
public class Cisrolepermission implements Serializable, Stamped {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date cdate;

  private Integer cidcisuser;

  @Temporal(TemporalType.TIMESTAMP)
  private Date ddate;

  private Integer didcisuser;

  private Integer idpermission;

  private Integer idrole;

  @Temporal(TemporalType.DATE)
  private Date validfrom;

  @Temporal(TemporalType.DATE)
  private Date validto;


  public Cisrolepermission() {
  }


  public Integer getId() {
    return this.id;
  }


  public void setId(final Integer id) {
    this.id = id;
  }


  public Date getCdate() {
    return this.cdate;
  }


  public void setCdate(final Date cdate) {
    this.cdate = cdate;
  }


  public Integer getCidcisuser() {
    return this.cidcisuser;
  }


  public void setCidcisuser(final Integer cidcisuser) {
    this.cidcisuser = cidcisuser;
  }


  public Date getDdate() {
    return this.ddate;
  }


  public void setDdate(final Date ddate) {
    this.ddate = ddate;
  }


  public Integer getDidcisuser() {
    return this.didcisuser;
  }


  public void setDidcisuser(final Integer didcisuser) {
    this.didcisuser = didcisuser;
  }


  public Integer getIdpermission() {
    return this.idpermission;
  }


  public void setIdpermission(final Integer idpermission) {
    this.idpermission = idpermission;
  }


  public Integer getIdrole() {
    return this.idrole;
  }


  public void setIdrole(final Integer idrole) {
    this.idrole = idrole;
  }


  public Date getValidfrom() {
    return this.validfrom;
  }


  public void setValidfrom(final Date validfrom) {
    this.validfrom = validfrom;
  }


  public Date getValidto() {
    return this.validto;
  }


  public void setValidto(final Date validto) {
    this.validto = validto;
  }
}
