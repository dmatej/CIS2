package cz.i.cis.person;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.date.CisDate;
import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.entities.Tduperson;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.person.PersonService;
import cz.i.cis.db.validate.IdentityValidateService;
import cz.i.cis.other.Constants;

@Named("identity")
@RequestScoped
public class IdentityFormBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private Identity selectedIdentity;

  private Integer idIdentity;

  private Date birthdate;

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

  private Boolean asActualIdentity = false;

  @EJB
  private IdentityService identityservicebean;

  @EJB
  private PersonService personservicebean;

  @EJB
  private IdentityValidateService identityValidateServicebean;

  public String createIdentity() {
    if (!testBeans())
      return "";

    Identity identity = generateEntity();
    identity.setIdperson(idperson);

    if (validateIdentity(identity)) {
      selectedIdentity = identityservicebean.create(identity);

      if(asActualIdentity)
      {
        Tduperson person = personservicebean.findPersonById(idperson);
        person.setIdidentityActual(selectedIdentity.getId());
        personservicebean.update(person);
      }

      return Constants.PAGE_VIEW_DETAIL + "?faces-redirect=true&amp;includeViewParams=true";
    }

    return null;
  }

  private Boolean validateIdentity(Identity identity) {
    String[] validate = identityValidateServicebean.validate(identity);
    if (validate == null) {
      FacesMessage message = new FacesMessage("Validace identity OK!");
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

    Identity newIdentity;
    newIdentity = generateEntity();
    newIdentity.setId(selectedIdentity.getId());
    if (validateIdentity(newIdentity)) {
      selectedIdentity = identityservicebean.update(newIdentity);
    }

  }

  public Identity generateEntity() {
    Identity identity = new Identity();
    try {
      identity.setBirthdate(CisDate.parseDate(birthdate));
    } catch (ParseException e) {
      FacesMessage message = new FacesMessage(
          "Chyba při parsování data narození");
      FacesContext.getCurrentInstance().addMessage(null, message);
    }

    identity.setBirthnumber(birthnumber);

    if(birthname == null) identity.setBirthname(lastname);
    else identity.setBirthname(birthname);

    identity.setBirthplace(birthplace);
    identity.setFirstname(firstname);
    identity.setIdperson(idperson);
    identity.setIdstate(idstate);
    identity.setIdstateofbirth(idstateofbirth);
    identity.setLastname(lastname);

    if(othernames == null) identity.setOthernames(lastname);
    else identity.setOthernames(othernames);

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

  public void clearForm()
  {
    Map<String,String> params =  FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    try
    {
      idperson = Integer.parseInt(params.get("personid"));
    }
    catch(Exception e) { idperson = null; }

    //for sure (thanks RequestScope are data deleted)
    birthdate = null;
    birthname = null;
    birthnumber = null;
    birthplace = null;
    firstname = null;
    idevidence = null;
    idperson = null;
    idstate = null;
    idstateofbirth = null;
    lastname = null;
    othernames = null;
    sex = null;
    validfrom = null;
    validto = null;
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

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
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

  public Date getValidfrom() {
    return validfrom;
  }

  public void setValidfrom(Date validfrom) {
    this.validfrom = validfrom;
  }

  public Date getValidto() {
    return validto;
  }

  public void setValidto(Date validto) {
    this.validto = validto;
  }

public Integer getIdperson() {
    return idperson;
}

public void setIdperson(Integer idperson) {
    this.idperson = idperson;
}

public Boolean getAsActualIdentity() {
    return asActualIdentity;
}

public void setAsActualIdentity(Boolean asActualIdentity) {
    this.asActualIdentity = asActualIdentity;
}

}
