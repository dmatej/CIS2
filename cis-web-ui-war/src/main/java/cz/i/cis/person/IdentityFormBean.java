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

        Identity identity = generateEntity();

        String[] validate = identityValidateServicebean.validate(identity);
        if (validate == null) {
            identity = identityservicebean.create(identity);

            FacesMessage message = new FacesMessage("Identita vytvořena!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            for (int i = 0; i < validate.length; i++) {
                FacesMessage message = new FacesMessage(
                        "Chyba při validaci identity! (" + validate[i] + ")");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            return null;
        }
        return identity;
    }

    public Identity generateEntity()
    {
        Identity identity = new Identity();
        identity.setBirthdate(birthdate);
        identity.setBirthname(birthname);
        identity.setBirthnumber(birthnumber);
        identity.setBirthplace(birthplace);
        identity.setFirstname(firstname);
        identity.setIdevidence(0); //TODO upravit
        identity.setIdorgunit(0);
        identity.setIdperson(idperson);
        identity.setIdstate(idstate);
        identity.setIdstateofbirth(idstateofbirth);
        identity.setLastname(lastname);
        identity.setOthernames(othernames);
        identity.setRstatus(0);
        identity.setSex(sex);
        identity.setValidfrom(validfrom);
        identity.setValidto(validto);

        return identity;

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

    public Integer getIdorgunit() {
        return idorgunit;
    }

    public void setIdorgunit(Integer idorgunit) {
        this.idorgunit = idorgunit;
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

    public Integer getRstatus() {
        return rstatus;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setRstatus(Integer rstatus) {
        this.rstatus = rstatus;
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
