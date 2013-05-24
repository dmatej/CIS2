package cz.i.cis.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.code.CodeService;
import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.person.PersonService;
import cz.i.cis.other.Constants;

@Named("personsview")
@RequestScoped
public class PersonsViewBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private PersonService personservicebean;

    @EJB
    private IdentityService identityservicebean;

    @EJB
    private CodeService codeservicebean;

    public List<Identity> listPersonsByActualIdentities() {

        return identityservicebean.findActualIdentitiesOfPersons();
    }

    public String formatSex(String sex) {
        if (sex.equalsIgnoreCase("M"))
            return "Muž";
        else if (sex.equalsIgnoreCase("Z"))
            return "Žena";

        return "-";
    }

    public String outcome()
    {
        return Constants.PAGE_VIEW_DETAIL;
    }
}
