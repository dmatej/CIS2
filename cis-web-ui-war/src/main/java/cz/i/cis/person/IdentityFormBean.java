package cz.i.cis.person;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import cz.i.cis.db.date.CisDate;
import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.entities.Tduperson;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.person.PersonService;
import cz.i.cis.db.validate.IdentityValidateService;
import cz.i.cis.other.Constants;

/**
 * Beana pro práci s identitami ve formuláři.
 *
 * @author Martin Štulc, Jan Šváb
 *
 */
@ManagedBean(name = "identity")
@ViewScoped
public class IdentityFormBean implements Serializable {
  /** serial version id */
  private static final long serialVersionUID = 1L;

  /** vybraná identita */
  private Identity selectedIdentity;

  /** id vybrané identity */
  private Integer idIdentity;

  /** datum narození */
  private Date birthdate;

  /** rodné jméno */
  private String birthname;

  /** rodné číslo */
  private String birthnumber;

  /** místo narození */
  private String birthplace;

  /** křestní jméno */
  private String firstname;

  /** id evidence */
  private Integer idevidence;

  /** id persony */
  private Integer idperson;

  /** id státu */
  private Integer idstate;

  /** id státu narození */
  private Integer idstateofbirth;

  /** příjmení */
  private String lastname;

  /** ostatní jména */
  private String othernames;

  /** pohlaví */
  private String sex;

  /** datum platnosti od */
  private Date validfrom;

  /** datm platnosti do */
  private Date validto;

  /** true pokud je identita nastavena jako aktuální; jinak false */
  private Boolean asActualIdentity = false;

  /** beana pro práci s identitama v databázi */
  @EJB
  private IdentityService identityservicebean;

  /** beana pro práci s personama v databázi */
  @EJB
  private PersonService personservicebean;

  /** beana pro validaci identit */
  @EJB
  private IdentityValidateService identityValidateServicebean;

  /**
   * Vytvoří identitu.
   *
   * @return url stránky pro zobrazení identity
   */
  public String createIdentity() {
    if (!testBeans())
      return "";

    Identity identity = generateEntity();
    identity.setIdperson(idperson);

    if (validateIdentity(identity)) {
      selectedIdentity = identityservicebean.create(identity);

      if (asActualIdentity) {
        Tduperson person = personservicebean.findPersonById(idperson);
        person.setIdidentityActual(selectedIdentity.getId());
        personservicebean.update(person);
      }

      return Constants.PAGE_VIEW_DETAIL
          + "?faces-redirect=true&amp;includeViewParams=true";
    }

    return null;
  }

  /**
   * Validuje identitu a vypíše chyby.
   *
   * @param identity
   *          validovaná identita
   * @return true, pokud validace proběhla v pořádku; jinak false
   */
  private Boolean validateIdentity(Identity identity) {
    String[] validate = identityValidateServicebean.validate(identity);

    if (validate == null) {
      return true;
    }

    for (int i = 0; i < validate.length; i++) {
      FacesMessage message = new FacesMessage("Chyba při validaci identity! ("
          + validate[i] + ")");
      FacesContext.getCurrentInstance().addMessage(null, message);
    }

    return false;
  }

  /**
   * Edituje identitu.
   *
   * @return url stránky pro zobrazení identity
   */
  public String updateIdentity() {
    Identity newIdentity;
    newIdentity = generateEntity();
    newIdentity.setId(selectedIdentity.getId());
    if (!validateIdentity(newIdentity)) {
      return null;
    }

    selectedIdentity.setBirthnumber(birthnumber);

    if (birthname == null)
      selectedIdentity.setBirthname(lastname);
    else
      selectedIdentity.setBirthname(birthname);

    selectedIdentity.setBirthplace(birthplace);
    selectedIdentity.setFirstname(firstname);
    selectedIdentity.setIdperson(idperson);
    selectedIdentity.setIdstate(idstate);
    selectedIdentity.setIdstateofbirth(idstateofbirth);
    selectedIdentity.setLastname(lastname);

    if (othernames == null)
      selectedIdentity.setOthernames(lastname);
    else
      selectedIdentity.setOthernames(othernames);

    selectedIdentity.setSex(sex);
    selectedIdentity.setValidfrom(validfrom);
    selectedIdentity.setValidto(validto);

    identityservicebean.update(selectedIdentity);

    return Constants.PAGE_VIEW_DETAIL + "?personid="
        + selectedIdentity.getIdperson()
        + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }

  /**
   * Vytvoří entitu identity z formuláře
   *
   * @return entita identity
   */
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

    if (birthname == null)
      identity.setBirthname(lastname);
    else
      identity.setBirthname(birthname);

    identity.setBirthplace(birthplace);
    identity.setFirstname(firstname);
    identity.setIdperson(idperson);
    identity.setIdstate(idstate);
    identity.setIdstateofbirth(idstateofbirth);
    identity.setLastname(lastname);

    if (othernames == null)
      identity.setOthernames(lastname);
    else
      identity.setOthernames(othernames);

    identity.setSex(sex);
    identity.setValidfrom(validfrom);
    identity.setValidto(validto);

    return identity;

  }

  /**
   * Načte aktuální identitu do formuláře.
   */
  public void loadIdentity() {
    if (FacesContext.getCurrentInstance().isPostback() || idIdentity == null) {
      return;
    }

    selectedIdentity = null;

    selectedIdentity = identityservicebean.findIdentityById(idIdentity);
    if (selectedIdentity == null) {
      FacesMessage message = new FacesMessage("Cílová identita nebyla nalezena");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return;
    }

    birthname = selectedIdentity.getBirthname();
    birthnumber = selectedIdentity.getBirthnumber();
    birthplace = selectedIdentity.getBirthplace();
    firstname = selectedIdentity.getFirstname();
    idperson = selectedIdentity.getIdperson();
    idstate = selectedIdentity.getIdstate();
    idstateofbirth = selectedIdentity.getIdstateofbirth();
    lastname = selectedIdentity.getLastname();
    othernames = selectedIdentity.getOthernames();
    sex = selectedIdentity.getSex();
    validfrom = selectedIdentity.getValidfrom();
    validto = selectedIdentity.getValidto();
  }

  /**
   * Smaže formulář.
   */
  public void clearForm() {
    Map<String, String> params = FacesContext.getCurrentInstance()
        .getExternalContext().getRequestParameterMap();
    try {
      idperson = Integer.parseInt(params.get("personid"));
    } catch (Exception e) {
      idperson = null;
    }

    // for sure (thanks RequestScope are data deleted)
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

  /**
   * Otestuje zda jsou dostupné injektované beany.
   *
   * @return true, pokud je vše OK
   */
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

  /**
   * @return křestní jméno
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * Nastaví křestní jméno.
   *
   * @param firstname
   *          křestní jméno
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * @return příjmení
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * Nastaví příjmení.
   *
   * @param lastname
   *          příjmení
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * @return místo narození
   */
  public String getBirthplace() {
    return birthplace;
  }

  /**
   * @return rodné jméno
   */
  public String getBirthname() {
    return birthname;
  }

  /**
   * Nastaví rodné jméno.
   *
   * @param birthname
   *          rodné jméno
   */
  public void setBirthname(String birthname) {
    this.birthname = birthname;
  }

  /**
   * @return id evidence
   */
  public Integer getIdevidence() {
    return idevidence;
  }

  /**
   * Nastaví id evidence.
   *
   * @param idevidence
   *          id evidence
   */
  public void setIdevidence(Integer idevidence) {
    this.idevidence = idevidence;
  }

  /**
   *
   * @return id státu
   */
  public Integer getIdstate() {
    return idstate;
  }

  /**
   * Nastaví id státu.
   *
   * @param idstate
   *          id státu
   */
  public void setIdstate(Integer idstate) {
    this.idstate = idstate;
  }

  /**
   * @return id státu narození
   */
  public Integer getIdstateofbirth() {
    return idstateofbirth;
  }

  /**
   * Nastaví id státu narození.
   *
   * @param idstateofbirth
   *          id státu narození
   */
  public void setIdstateofbirth(Integer idstateofbirth) {
    this.idstateofbirth = idstateofbirth;
  }

  /**
   * @return ostatní jména
   */
  public String getOthernames() {
    return othernames;
  }

  /**
   * Nastaví ostatní jména.
   *
   * @param othernames
   *          ostatní jména
   */
  public void setOthernames(String othernames) {
    this.othernames = othernames;
  }

  /**
   * @return datum narození
   */
  public Date getBirthdate() {
    return birthdate;
  }

  /**
   * Nastaví datum narození.
   *
   * @param birthdate
   *          datum narození
   */
  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  /**
   * Nastaví místo narození.
   *
   * @param birthplace
   *          místo narození
   */
  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  /**
   * @return rodné číslo
   */
  public String getBirthnumber() {
    return birthnumber;
  }

  /**
   * Naství rodné číslo.
   *
   * @param birthnumber
   *          rodné číslo
   */
  public void setBirthnumber(String birthnumber) {
    this.birthnumber = birthnumber;
  }

  /**
   * @return pohlaví
   */
  public String getSex() {
    return sex;
  }

  /**
   * Nastaví pohlaví.
   *
   * @param sex
   *          pohlaví
   */
  public void setSex(String sex) {
    this.sex = sex;
  }

  /**
   * @return id aktuální identity
   */
  public Integer getIdIdentity() {
    return idIdentity;
  }

  /**
   * Naství id aktuální identity
   *
   * @param idIdentity
   *          id aktuální identity
   */
  public void setIdIdentity(Integer idIdentity) {
    this.idIdentity = idIdentity;
  }

  /**
   * @return datum platnosti od
   */
  public Date getValidfrom() {
    return validfrom;
  }

  /**
   * Nastaví datum platností od
   *
   * @param validfrom
   *          datum platnosti od
   */
  public void setValidfrom(Date validfrom) {
    this.validfrom = validfrom;
  }

  /**
   * @return datum platnosti do
   */
  public Date getValidto() {
    return validto;
  }

  /**
   * Nastaví datum platnosti do.
   *
   * @param validto
   *          datum platnosti do
   */
  public void setValidto(Date validto) {
    this.validto = validto;
  }

  /**
   * @return id persony
   */
  public Integer getIdperson() {
    return idperson;
  }

  /**
   * Nastaví id persony.
   *
   * @param idperson
   *          id persony
   */
  public void setIdperson(Integer idperson) {
    this.idperson = idperson;
  }

  /**
   * @return true, pokud je idenita nastavená jako aktuální; jinak false
   */
  public Boolean getAsActualIdentity() {
    return asActualIdentity;
  }

  /**
   * Nastaví aktuálnost identity.
   *
   * @param asActualIdentity
   *          true, pokud je idenita nastavená jako aktuální; jinak false
   */
  public void setAsActualIdentity(Boolean asActualIdentity) {
    this.asActualIdentity = asActualIdentity;
  }

}
