package cz.i.cis.person;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.entities.Tduperson;
import cz.i.cis.db.person.PersonService;

@Named("person")
public class PersonFormBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private PersonService personservicebean;

    private Integer ididentityActual;

    public Tduperson createPerson() {
        if(personservicebean == null)
        {
            FacesMessage message = new FacesMessage("personservicebean null!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            return null;
        }
        Tduperson person = new Tduperson();
        person.setIdidentityActual(ididentityActual);

        person = personservicebean.create(person);

        FacesMessage message = new FacesMessage("Persona vytvořena!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return person;
    }

    public List<Tduperson> getPersons() {
        if(personservicebean == null)
        {
            FacesMessage message = new FacesMessage("personservicebean null!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            return null;
        }

        return personservicebean.getPersons();
    }

    public String getMessage()
    {
        if(personservicebean == null)
        {
            return "personservicebean null!";
        }

        return "Vše připraveno";
    }

  public Integer getIdidentityActual() {
    return ididentityActual;
  }

  public void setIdidentityActual(Integer ididentityActual) {
    this.ididentityActual = ididentityActual;
  }



}
