package cz.i.cis.person;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.person.PersonService;

@ManagedBean(name="person")
public class PersonFormBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstname;
    private String lastname;
    private String birthplace;
    private String birthnumber;
    private String sex;

    @EJB
    private PersonService personservicebean;


    public void createPerson() {
        if(personservicebean == null)
        {
            FacesMessage message = new FacesMessage("personservicebean null!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            return;
        }

        personservicebean.create(firstname, lastname, birthnumber, birthplace, sex);

        FacesMessage message = new FacesMessage("Identita vytvořena!");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Identity> getPersons() {
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
}
