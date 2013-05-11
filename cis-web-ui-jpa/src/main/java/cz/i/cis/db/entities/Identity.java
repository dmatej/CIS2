package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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
	private Integer id;

	private Integer idevidence;

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

	public String getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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

	public Integer getIdevidence() {
		return this.idevidence;
	}

	public void setIdevidence(Integer idevidence) {
		this.idevidence = idevidence;
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