package cz.i.cis.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.entities.Tduperson;
import cz.i.cis.db.entities.Tdustay;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.person.PersonService;
import cz.i.cis.db.person.StayService;

@ManagedBean(name="personview")
@ViewScoped
public class PersonViewBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private PersonService personservicebean;

    @EJB
    private IdentityService identityservicebean;

    @EJB
    private StayService stayservicebean;

    private Tduperson selectedPerson;
    private Identity actualPersonIdentity;
    private Integer idperson;

    private Integer renderedTab = 0;

    public void loadPerson() {
        if (FacesContext.getCurrentInstance().isPostback() || idperson == null) {
            return;
        }

        selectedPerson = null;
        actualPersonIdentity = null;

        selectedPerson = personservicebean.findPersonById(idperson);
        if (selectedPerson == null) {
            // TODO hlaska
            return;
        }

        Integer idIdentity = selectedPerson.getIdidentityActual();
        actualPersonIdentity = identityservicebean.findIdentityById(idIdentity);
    }

    public List<Identity> listIdentities() {

        if (selectedPerson == null)
            return new ArrayList<Identity>();

        return identityservicebean.findIdentitiesForPerson(selectedPerson
                .getId());
    }

    public List<Tdustay> listStays() {
        if (selectedPerson == null)
            return new ArrayList<Tdustay>();

        return stayservicebean.getStaysForPerson(selectedPerson.getId());
    }

    public void handleTabChange(Integer idTab) {
        renderedTab = idTab;
    }

    public Tduperson getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Tduperson selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public Identity getActualPersonIdentity() {
        return actualPersonIdentity;
    }

    public void setActualPersonIdentity(Identity actualPersonIdentity) {
        this.actualPersonIdentity = actualPersonIdentity;
    }

    public Integer getIdperson() {
        return idperson;
    }

    public void setIdperson(Integer idperson) {
        this.idperson = idperson;
    }

    public Integer getRenderedTab() {
        return renderedTab;
    }

    public void setRenderedTab(Integer renderedTab) {
        this.renderedTab = renderedTab;
    }
}
