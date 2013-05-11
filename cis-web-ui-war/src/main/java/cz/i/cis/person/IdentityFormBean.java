package cz.i.cis.person;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.validate.IdentityValidateService;

@Named("identity")
public class IdentityFormBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String birthdate;

    private String birthname;

    private String birthnumber;

    private String birthplace;

    private String firstname;

    private Integer idevidence;

    private Integer idorgunit;

    private Integer idperson;

    private Integer idstate;

    private Integer idstateofbirth;

    private String lastname;

    private String othernames;

    private Integer rstatus;

    private String sex;

    private Date validfrom;

    private Date validto;

    @EJB
    private IdentityService identityservicebean;

    @EJB
    private IdentityValidateService identityValidateServicebean;

    public Identity createIdentity() {
        if (identityservicebean == null) {
            FacesMessage message = new FacesMessage("identityservicebean null!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            return null;
        }
        Identity identity = new Identity();
        identity.setBirthdate(birthdate);
        identity.setBirthname(birthname);
        identity.setBirthnumber(birthnumber);
        identity.setBirthplace(birthplace);
        identity.setFirstname(firstname);
        identity.setIdevidence(idevidence);
        identity.setIdorgunit(idorgunit);
        identity.setIdperson(idperson);
        identity.setIdstate(idstate);
        identity.setIdstateofbirth(idstateofbirth);
        identity.setLastname(lastname);
        identity.setOthernames(othernames);
        identity.setRstatus(rstatus);
        identity.setSex(sex);
        identity.setValidfrom(validfrom);
        identity.setValidto(validto);

        if (identityValidateServicebean.validate(identity)) {
            identity = identityservicebean.create(identity);

            FacesMessage message = new FacesMessage("Identita vytvořena!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(
                    "Chyba při validaci identity!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
        return identity;
    }

    public List<Identity> getIdentitiesForPerson(Integer idPerson) {
        if (identityservicebean == null) {
            FacesMessage message = new FacesMessage("personservicebean null!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            return null;
        }

        return identityservicebean.getIdentitiesForPerson(idPerson);
    }

    public String getMessage() {
        if (identityservicebean == null) {
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
