package cz.i.cis.db.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cz.i.cis.db.date.CisDate;

/**
 * The persistent class for the identity database table.
 *
 */
@Entity
public class Identity implements Serializable {
  private static final long serialVersionUID = 1L;

  private String birthdate;

  private String birthname;

  private String birthnumber;

  private String birthplace;

  private String firstname;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer idorgunit;

  private Integer idperson;

  private Integer idstate;

  private Integer idstateofbirth;

  private String lastname;

  private String othernames;

  private Integer rstatus;

  private String sex;

  @Temporal(TemporalType.DATE)
  private Date validfrom;

  @Temporal(TemporalType.DATE)
  private Date validto;

  public Identity() {
  }

  public CisDate getBirthdate() {
    if (this.birthdate == null) {
      return CisDate.EMPTY;
    }
    return new CisDate(this.birthdate);
  }

  public void setBirthdate(CisDate birthdate) {
    if (birthdate == null) {
      this.birthdate = CisDate.EMPTY.getCisValue();
    } else {
      this.birthdate = birthdate.getCisValue();
    }
  }

  public String getBirthname() {
    return this.birthname;
  }

  public void setBirthname(String birthname) {
    this.birthname = birthname;
  }

  public String getBirthnumber() {
    return this.birthnumber;
  }

  public void setBirthnumber(String birthnumber) {
    this.birthnumber = birthnumber;
  }

  public String getBirthplace() {
    return this.birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getIdorgunit() {
    return this.idorgunit;
  }

  public void setIdorgunit(Integer idorgunit) {
    this.idorgunit = idorgunit;
  }

  public Integer getIdperson() {
    return this.idperson;
  }

  public void setIdperson(Integer idperson) {
    this.idperson = idperson;
  }

  public Integer getIdstate() {
    return this.idstate;
  }

  public void setIdstate(Integer idstate) {
    this.idstate = idstate;
  }

  public Integer getIdstateofbirth() {
    return this.idstateofbirth;
  }

  public void setIdstateofbirth(Integer idstateofbirth) {
    this.idstateofbirth = idstateofbirth;
  }

  public String getLastname() {
    return this.lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getOthernames() {
    return this.othernames;
  }

  public void setOthernames(String othernames) {
    this.othernames = othernames;
  }

  public Integer getRstatus() {
    return this.rstatus;
  }

  public void setRstatus(Integer rstatus) {
    this.rstatus = rstatus;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
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
