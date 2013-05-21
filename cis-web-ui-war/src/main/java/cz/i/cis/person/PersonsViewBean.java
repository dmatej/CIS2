package cz.i.cis.person;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.person.PersonService;

@Named("personview")
@RequestScoped
public class PersonsViewBean implements Serializable{
    private static final long serialVersionUID = 1L;

    @EJB
    private PersonService personservicebean;

    @EJB
    private IdentityService identityservicebean;

    public List<Identity> listPersonsByActualIdentities()
    {
        return identityservicebean.findActualIdentitiesOfPersons();
    }

    /**
     * @param firstname
     * @param lastname
     * @param sex
     * @param ageFrom
     * @param ageTo
     * @param isMale
     * @return Mapa, kde klicem je ID tduperson a hodnotou seznam nalezenych identit, které patri dane osobe.
     */
    private HashMap<Integer, List<Identity>> searchPersonsByName(String firstname, String lastname, String sex, Integer ageFrom, Integer ageTo, Boolean isMale)
    {
        //TODO [Honza->Martin] implementovat
        return null;
    }
}
