package cz.i.cis.person;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.entities.Tduperson;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.person.PersonService;
import cz.i.cis.db.validate.IdentityValidateService;
import cz.i.cis.db.validate.PersonValidateService;
import cz.i.cis.other.Constants;

/**
 * Beana pro práci s personou ve formuláři.
 *
 * @author Martin Štulc, Jan Šváb
 *
 */
@Named("person")
@RequestScoped
public class PersonFormBean implements Serializable {
  /** serial version id */
  private static final long serialVersionUID = 1L;

  /** beana pro práci s personama */
  @EJB
  private PersonService personservicebean;

  /** beana pro práci s identitama */
  @EJB
  private IdentityService identityservicebean;

  /** beana pro validaci persony */
  @EJB
  private PersonValidateService personValidateServicebean;

  /** beana pro validaci identity */
  @EJB
  private IdentityValidateService identityValidateServicebean;

  /** vybraná persona */
  private Tduperson selectedPerson;

  /** id vybrané persony */
  private Integer idperson;

  /** id aktuální identity */
  private Integer ididentityActual;

  /** datum úmrtí */
  private Date deathdate;

  /** místo úmrtí */
  private String deathplace;

  /** titul před jménem */
  private String degreeprefix;

  /** titul za jménem */
  private String degreesuffix;

  /** id místa úmrtí */
  private Integer iddeathplace;

  /** id státu úmrtí */
  private Integer iddeathstate;

  /** id fotky */
  private Integer idimage;

  /** id aktuálního pobytu */
  private Integer idstayActual;

  /** id aktuálního místa pobytu */
  private Integer idstayplaceActual;

  /** poznámka */
  private String note;

  /**
   * Vytvoří personu s hlavní identitou.
   *
   * @param identity
   *          nová hlavní identita persony.
   * @return true, pokud vytvoření proběhlo úspěšně
   */
  public Boolean createPersonWithIdentity(Identity identity) {
    if (!testBeans())
      return false;

    Tduperson person = generateEntity();
    if (validateIdentity(identity) && validatePerson(person)) {
      person = personservicebean.create(person);
      identity.setIdperson(person.getId());
      identity = identityservicebean.create(identity);
      person.setIdidentityActual(identity.getId());
      selectedPerson = personservicebean.update(person);

    } else
      return false;

    return true;
  }

  /**
   * Vytvoří personu.
   *
   * @return url na detail persony
   */
  public String createPerson() {
    if (!testBeans())
      return "";

    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    Object ret = elContext.getELResolver()
        .getValue(elContext, null, "identity");

    IdentityFormBean identityFormBean = (IdentityFormBean) ret;
    Identity actualId = identityFormBean.generateEntity();

    if (!createPersonWithIdentity(actualId))
      return "";

    return Constants.PAGE_VIEW_PERSONS;
  }

  /**
   * Upraví personu.
   */
  public void updatePerson() {
    if (!testBeans())
      return;

    Tduperson newPerson = generateEntity();
    newPerson.setId(selectedPerson.getId());
    if (validatePerson(newPerson)) {
      selectedPerson = personservicebean.update(selectedPerson);
    }
  }

  /**
   * Validuje personu a vypíše chybové hlášky.
   *
   * @param person
   *          validovaná persona
   * @return truen pokud nebyly nalezeny chyby; jinak false
   */
  private Boolean validatePerson(Tduperson person) {
    String[] validate = personValidateServicebean.validate(person);
    if (validate == null) {
      return true;
    } else {
      for (int i = 0; i < validate.length; i++) {
        FacesMessage message = new FacesMessage("Chyba při validaci persony! ("
            + validate[i] + ")");
        FacesContext.getCurrentInstance().addMessage(null, message);
      }
      return false;
    }
  }

  /**
   * Validuje identitu a vypíše chybové hlášky.
   *
   * @param person
   *          validovaná identita
   * @return truen pokud nebyly nalezeny chyby; jinak false
   */
  private Boolean validateIdentity(Identity identity) {
    String[] validate = identityValidateServicebean.validate(identity);
    if (validate == null) {
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

  /**
   * Načte personu dle nastaveného idperson.
   */
  public void loadPerson() {
    if (FacesContext.getCurrentInstance().isPostback() || idperson == null) {
      return;
    }

    selectedPerson = null;

    selectedPerson = personservicebean.findPersonById(idperson);
    if (selectedPerson == null) {
      // TODO hlaska
      return;
    }
  }

  /**
   * Testuje dostupnost bean.
   *
   * @return true pokud je vše OK.
   */
  private boolean testBeans() {
    if (personservicebean == null) {
      FacesMessage message = new FacesMessage("personservicebean null!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return false;
    }

    if (identityservicebean == null) {
      FacesMessage message = new FacesMessage("identityservicebean null!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return false;
    }

    if (personValidateServicebean == null) {
      FacesMessage message = new FacesMessage("personValidateServicebean null!");
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
    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    Object ret = elContext.getELResolver()
        .getValue(elContext, null, "identity");

    IdentityFormBean identityFormBean = (IdentityFormBean) ret;
    identityFormBean.clearForm();

    deathdate = null;
    deathplace = null;
    degreeprefix = null;
    degreesuffix = null;
    iddeathplace = null;
    iddeathstate = null;
    idimage = null;
    idstayActual = null;
    idstayplaceActual = null;
    note = null;
  }

  /**
   * Vytvoří entitu persony z pormuláře.
   *
   * @return entita persony
   */
  private Tduperson generateEntity() {
    Tduperson person = new Tduperson();

    person.setIdidentityActual(ididentityActual);
    person.setCdate(new Timestamp(new Date().getTime()));
    person.setDeathdate(deathdate);
    person.setDeathplace(deathplace);
    person.setDegreeprefix(degreeprefix);
    person.setDegreesuffix(degreesuffix);
    person.setIddeathplace(iddeathplace);
    person.setIddeathstate(iddeathstate);
    person.setIdimage(idimage);
    person.setIdstayActual(idstayActual);
    person.setIdstayplaceActual(idstayplaceActual);
    person.setNote(note);
    return person;
  }

  /**
   * @return id aktuální identity
   */
  public Integer getIdidentityActual() {
    return ididentityActual;
  }

  /**
   * Nastaví id aktuální identity.
   *
   * @param ididentityActual
   *          id aktuální identity
   */
  public void setIdidentityActual(Integer ididentityActual) {
    this.ididentityActual = ididentityActual;
  }

  /**
   * @return datum úmrtí
   */
  public Date getDeathdate() {
    return deathdate;
  }

  /**
   * Nastaví datum úmrtí.
   *
   * @param deathdate
   *          datum úmrtí
   */
  public void setDeathdate(Date deathdate) {
    this.deathdate = deathdate;
  }

  /**
   * @return místo úmrtí
   */
  public String getDeathplace() {
    return deathplace;
  }

  /**
   * Nastaví místo úmrtí
   *
   * @param deathplace
   *          místo úmrtí
   */
  public void setDeathplace(String deathplace) {
    this.deathplace = deathplace;
  }

  /**
   * @return titul před jménem
   */
  public String getDegreeprefix() {
    return degreeprefix;
  }

  /**
   * Nastaví titul před jménem.
   *
   * @param degreeprefix
   *          titul před jménem
   */
  public void setDegreeprefix(String degreeprefix) {
    this.degreeprefix = degreeprefix;
  }

  /**
   * @return titul za jménem
   */
  public String getDegreesuffix() {
    return degreesuffix;
  }

  /**
   * Nastaví titul za jménem.
   *
   * @param degreesuffix
   *          titul za jménem
   */
  public void setDegreesuffix(String degreesuffix) {
    this.degreesuffix = degreesuffix;
  }

  /**
   * @return id místa úmrtí
   */
  public Integer getIddeathplace() {
    return iddeathplace;
  }

  /**
   * Nastaví id místa úmrtí
   *
   * @param iddeathplace
   *          id místa úmrtí
   */
  public void setIddeathplace(Integer iddeathplace) {
    this.iddeathplace = iddeathplace;
  }

  /**
   * @return id státu úmrtí
   */
  public Integer getIddeathstate() {
    return iddeathstate;
  }

  /**
   * Nastaví id státu úmrtí
   *
   * @param iddeathstate
   *          id státu úmrtí
   */
  public void setIddeathstate(Integer iddeathstate) {
    this.iddeathstate = iddeathstate;
  }

  /**
   * @return id fotky
   */
  public Integer getIdimage() {
    return idimage;
  }

  /**
   * Nastaví id fotky.
   *
   * @param idimage
   *          id fotky
   */
  public void setIdimage(Integer idimage) {
    this.idimage = idimage;
  }

  /**
   * @return id aktuálního místa pobytu
   */
  public Integer getIdstayActual() {
    return idstayActual;
  }

  /**
   * Nastaví id aktuálního msta pobytu
   *
   * @param idstayActual
   *          id aktuálního místa pobytu
   */
  public void setIdstayActual(Integer idstayActual) {
    this.idstayActual = idstayActual;
  }

  /**
   * @return id aktuálního místa pobytu
   */
  public Integer getIdstayplaceActual() {
    return idstayplaceActual;
  }

  /**
   * Nastaví id aktuálního místa pobytu.
   *
   * @param idstayplaceActual
   *          id aktuálního místa pobytu
   */
  public void setIdstayplaceActual(Integer idstayplaceActual) {
    this.idstayplaceActual = idstayplaceActual;
  }

  /**
   * @return poznámka
   */
  public String getNote() {
    return note;
  }

  /**
   * Nastaví poznámku.
   *
   * @param note
   *          poznámka
   */
  public void setNote(String note) {
    this.note = note;
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
}
