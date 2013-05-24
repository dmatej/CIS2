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

    private Boolean filtered = false;

    private Map<Integer, List<Identity>> mapOfPersonsIdentities;

    public void filtrPersons() {
        filtered = true;

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        Object ret = elContext.getELResolver()
            .getValue(elContext, null, "filterpersons");

        FilterPersonsBean filterBean = (FilterPersonsBean) ret;

        if (filterBean != null) {
            Boolean isMale = null;
            if (filterBean.getSex() != null) {
                if (filterBean.getSex().equalsIgnoreCase("M"))
                    isMale = true;
                else if (filterBean.getSex().equalsIgnoreCase("Z"))
                    isMale = false;
            }

            mapOfPersonsIdentities = searchIdentities(filterBean.getFirstname(),
                    filterBean.getLastname(), isMale, filterBean.getBirthnumber());
        } else
            mapOfPersonsIdentities = new HashMap<Integer, List<Identity>>();
    }

    public List<Identity> listPersonsByActualIdentities() {
        filtered = false;
        mapOfPersonsIdentities = null;

        return identityservicebean.findActualIdentitiesOfPersons();
    }

    /**
     * @return Mapa, kde klicem je ID tduperson a hodnotou seznam nalezenych
     *         identit, které patri dane osobe.
     */
    private Map<Integer, List<Identity>> searchIdentities(String firstName,
            String lastName, Boolean isMale, String birthNumber) {

        List<Identity> identList = identityservicebean.findIdentitiesByParams(
                firstName, lastName, isMale, birthNumber);

        Map<Integer, List<Identity>> map = new HashMap<Integer, List<Identity>>();
        for (Identity ident : identList) {
            if (!map.containsKey(ident.getIdperson())) {
                map.put(ident.getIdperson(), new ArrayList<Identity>());
            }
            map.get(ident.getIdperson()).add(ident);

        }
        return map;
    }

    public String formatSex(String sex) {
        if (sex.equalsIgnoreCase("M"))
            return "Muž";
        else if (sex.equalsIgnoreCase("Z"))
            return "Žena";

        return "-";
    }

    public Boolean getFiltered() {
        return filtered;
    }
}
