package cz.i.cis.person;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.person.IdentityService;

@ManagedBean(name="identity")
public class IdentityFormBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstname;
    private String lastname;
    private String birthplace;
    private String birthnumber;
    private String sex;

    @EJB
    private IdentityService identityservicebean;


    public Identity createIdentity() {
        if(identityservicebean == null)
        {
            FacesMessage message = new FacesMessage("identityservicebean null!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            return null;
        }
        Identity identity = new Identity();
        identity.setFirstname(firstname);
        identity.setLastname(lastname);
        identity.setBirthplace(birthplace);
        identity.setBirthnumber(birthnumber);
        identity.setSex(sex);


        identity = identityservicebean.create(identity);

        FacesMessage message = new FacesMessage("Identita vytvořena!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return identity;
    }

    public List<Identity> getIdentitiesForPerson(Integer idPerson) {
        if(identityservicebean == null)
        {
            FacesMessage message = new FacesMessage("personservicebean null!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            return null;
        }

        return identityservicebean.getIdentitiesForPerson(idPerson);
    }

    public String getMessage()
    {
        if(identityservicebean == null)
        {
            return "identityservicebean null!";
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
