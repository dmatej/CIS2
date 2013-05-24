package cz.i.cis.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.entities.Tduperson;
import cz.i.cis.db.entities.Tdustay;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.person.PersonService;
import cz.i.cis.db.person.StayService;

@Named("personview")
@RequestScoped
public class PersonDetailViewBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private PersonService personservicebean;

    @EJB
    private IdentityService identityservicebean;

    @EJB
    private StayService stayservicebean;

    private Tduperson selectedPerson;
    private Identity actualPersonIdentity;

    public void loadPerson(Integer idperson) {
        selectedPerson = null;
        actualPersonIdentity = null;

        if (idperson == null) {
            return;
        }

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

    public Tduperson getSelectedPerson() {
        return selectedPerson;
    }

    public Identity getActualPersonIdentity() {
        return actualPersonIdentity;
    }
}
