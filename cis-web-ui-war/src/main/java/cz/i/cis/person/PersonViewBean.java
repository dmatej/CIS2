package cz.i.cis.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.entities.Tduperson;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.person.PersonService;

@Named("personview")
@RequestScoped
public class PersonViewBean implements Serializable{
    private static final long serialVersionUID = 1L;

    @EJB
    private PersonService personservicebean;

    @EJB
    private IdentityService identityservicebean;

    private Tduperson selectedPerson;
    private Identity actualPersonIdentity;


    public Boolean handlePersonSelection()
    {
        selectedPerson = null;
        actualPersonIdentity = null;

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Integer id = Integer.parseInt(externalContext.getRequestParameterMap().get("personid"));

        selectedPerson = personservicebean.getPerson(id);

        id = selectedPerson.getIdidentityActual();
        actualPersonIdentity = identityservicebean.getConcreteIdentityForPerson(id);

        return true;
    }

    public List<Identity> getIdentitiesForPerson() {

        if(selectedPerson == null) return new ArrayList<Identity>();

        return identityservicebean.getIdentitiesForPerson(selectedPerson.getId());
    }

    public List<Identity> getListPersonsByActualIdentities()
    {
        return identityservicebean.getActualIdentitiesOfPersons();
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
}