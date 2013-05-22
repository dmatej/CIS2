package cz.i.cis.person;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.validate.IdentityValidateService;

@Named("identity")
@RequestScoped
public class IdentityFormBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private Identity selectedIdentity;

  private Integer idIdentity;

  private String birthdate;

  private String birthname;

  private String birthnumber;

  private String birthplace;

  private String firstname;

  private Integer idevidence;

  private Integer idperson;

  private Integer idstate;

  private Integer idstateofbirth;

  private String lastname;

  private String othernames;

  private String sex;

  private Date validfrom;

  private Date validto;

  @EJB
  private IdentityService identityservicebean;

  @EJB
  private IdentityValidateService identityValidateServicebean;

  public void createIdentity() {
    if (!testBeans())
      return;

    Identity identity = generateEntity();

    if (validate(identity)) {
      selectedIdentity = identityservicebean.create(identity);
    }
  }

  private Boolean validate(Identity identity) {
    String[] validate = identityValidateServicebean.validate(identity);
    if (validate == null) {
      FacesMessage message = new FacesMessage("Validace OK!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return true;
    } else {
      for (int i = 0; i < validate.length; i++) {
        FacesMessage message = new FacesMessage(
            "Chyba při validaci identity! (" + validate[i] + ")");
        FacesContext.getCurrentInstance().addMessage(null, message);
      }
      return false;
    }
  }

  public void updateIdentity() {
    if (!testBeans())
      return;

    Identity newIdentity = generateEntity();
    newIdentity.setId(selectedIdentity.getId());
    if (validate(newIdentity)) {
      selectedIdentity = identityservicebean.update(newIdentity);
    }
  }

  public Identity generateEntity() {
    Identity identity = new Identity();
    identity.setBirthdate(birthdate);
    identity.setBirthname(birthname);
    identity.setBirthnumber(birthnumber);
    identity.setBirthplace(birthplace);
    identity.setFirstname(firstname);
    identity.setIdevidence(0); // TODO upravit identity.setIdevidence(0);
    identity.setIdperson(idperson);
    identity.setIdstate(idstate);
    identity.setIdstateofbirth(idstateofbirth);
    identity.setLastname(lastname);
    identity.setOthernames(othernames);
    identity.setSex(sex);
    identity.setValidfrom(validfrom);
    identity.setValidto(validto);

    return identity;

  }

  public void loadIdentity() {
    if (FacesContext.getCurrentInstance().isPostback() || idIdentity == null) {
      return;
    }

    selectedIdentity = null;

    selectedIdentity = identityservicebean.findIdentityById(idIdentity);
    if (selectedIdentity == null) {
      // TODO hlaska
      return;
    }
  }

  private boolean testBeans() {
    if (identityservicebean == null) {
      FacesMessage message = new FacesMessage("identityservicebean null!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return false;
    }

    if (identityValidateServicebean == null) {
      FacesMessage message = new FacesMessage(
          "identityValidateServicebean null!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return false;
    }

    return true;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getBirthplace() {
    return birthplace;
  }

  public String getBirthname() {
    return birthname;
  }

  public void setBirthname(String birthname) {
    this.birthname = birthname;
  }

  public Integer getIdevidence() {
    return idevidence;
  }

  public void setIdevidence(Integer idevidence) {
    this.idevidence = idevidence;
  }

  public Integer getIdstate() {
    return idstate;
  }

  public void setIdstate(Integer idstate) {
    this.idstate = idstate;
  }

  public Integer getIdstateofbirth() {
    return idstateofbirth;
  }

  public void setIdstateofbirth(Integer idstateofbirth) {
    this.idstateofbirth = idstateofbirth;
  }

  public String getOthernames() {
    return othernames;
  }

  public void setOthernames(String othernames) {
    this.othernames = othernames;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public String getBirthnumber() {
    return birthnumber;
  }

  public void setBirthnumber(String birthnumber) {
    this.birthnumber = birthnumber;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Integer getIdIdentity() {
    return idIdentity;
  }

  public void setIdIdentity(Integer idIdentity) {
    this.idIdentity = idIdentity;
  }

}
