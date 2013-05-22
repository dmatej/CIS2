package cz.i.cis.person;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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

@Named("person")
@RequestScoped
public class PersonFormBean implements Serializable {

  private static final long serialVersionUID = 1L;

  @EJB
  private PersonService personservicebean;

  @EJB
  private IdentityService identityservicebean;

  @EJB
  private PersonValidateService personValidateServicebean;

  @EJB
  private IdentityValidateService identityValidateServicebean;

  private Tduperson selectedPerson;

  private Integer idperson;

  private Integer ididentityActual;

  private Date deathdate;

  private String deathplace;

  private String degreeprefix;

  private String degreesuffix;

  private Integer iddeathplace;

  private Integer iddeathstate;

  private Integer idimage;

  private Integer idstayActual;

  private Integer idstayplaceActual;

  private String note;

  public Tduperson createPersonWithIdentity(Identity identity) {
    if (!testBeans())
      return null;

    Tduperson person = generateEntity();
    String[] validatePerson = personValidateServicebean.validate(person);
    String[] validateIdentity = identityValidateServicebean.validate(identity);
    if (validatePerson == null && validateIdentity == null) {

      person = personservicebean.create(person);
      identity.setIdperson(person.getId());
      identity = identityservicebean.create(identity);
      person.setIdidentityActual(identity.getId());
      personservicebean.update(person);

      FacesMessage message = new FacesMessage(
          "Persona s hlavní identitou vytvořena!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return person;
    } else {
      for (int i = 0; i < validatePerson.length; i++) {
        FacesMessage message = new FacesMessage(
            "Chyba při validaci identity! (" + validatePerson[i] + ")");
        FacesContext.getCurrentInstance().addMessage(null, message);
      }
      return null;
    }
  }

  public void createPerson() {
    if (!testBeans())
      return;

    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    Object ret = elContext.getELResolver()
        .getValue(elContext, null, "identity");

    IdentityFormBean identityFormBean = (IdentityFormBean) ret;
    Identity actualId = identityFormBean.generateEntity();

    createPersonWithIdentity(actualId);

    return;
  }

  public void updatePerson() {
    if (!testBeans())
      return;

    Tduperson newPerson = generateEntity();
    newPerson.setId(selectedPerson.getId());
    selectedPerson = newPerson;
    personservicebean.update(selectedPerson);
  }

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

  public Integer getIdidentityActual() {
    return ididentityActual;
  }

  public void setIdidentityActual(Integer ididentityActual) {
    this.ididentityActual = ididentityActual;
  }

  public PersonService getPersonservicebean() {
    return personservicebean;
  }

  public void setPersonservicebean(PersonService personservicebean) {
    this.personservicebean = personservicebean;
  }

  public Date getDeathdate() {
    return deathdate;
  }

  public void setDeathdate(Date deathdate) {
    this.deathdate = deathdate;
  }

  public String getDeathplace() {
    return deathplace;
  }

  public void setDeathplace(String deathplace) {
    this.deathplace = deathplace;
  }

  public String getDegreeprefix() {
    return degreeprefix;
  }

  public void setDegreeprefix(String degreeprefix) {
    this.degreeprefix = degreeprefix;
  }

  public String getDegreesuffix() {
    return degreesuffix;
  }

  public void setDegreesuffix(String degreesuffix) {
    this.degreesuffix = degreesuffix;
  }

  public Integer getIddeathplace() {
    return iddeathplace;
  }

  public void setIddeathplace(Integer iddeathplace) {
    this.iddeathplace = iddeathplace;
  }

  public Integer getIddeathstate() {
    return iddeathstate;
  }

  public void setIddeathstate(Integer iddeathstate) {
    this.iddeathstate = iddeathstate;
  }

  public Integer getIdimage() {
    return idimage;
  }

  public void setIdimage(Integer idimage) {
    this.idimage = idimage;
  }

  public Integer getIdstayActual() {
    return idstayActual;
  }

  public void setIdstayActual(Integer idstayActual) {
    this.idstayActual = idstayActual;
  }

  public Integer getIdstayplaceActual() {
    return idstayplaceActual;
  }

  public void setIdstayplaceActual(Integer idstayplaceActual) {
    this.idstayplaceActual = idstayplaceActual;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Integer getIdperson() {
    return idperson;
  }

  public void setIdperson(Integer idperson) {
    this.idperson = idperson;
  }

}
