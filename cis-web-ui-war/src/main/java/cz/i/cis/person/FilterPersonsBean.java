/**
 *
 */
package cz.i.cis.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.person.IdentityService;

@Named("filterpersons")
@RequestScoped
public class FilterPersonsBean {
    @EJB
    private IdentityService identityservicebean;

    private String firstname;
    private String lastname;
    private String birthnumber = null;
    private String sex;

    private Boolean filterOn = false;

    private List<Identity> foundIdentities;

    private List<Identity> searchIdentities() {
        Boolean isMale = null;
        if (sex != null) {
            if (sex.equalsIgnoreCase("M"))
                isMale = true;
            else if (sex.equalsIgnoreCase("Z"))
                isMale = false;
        }

        if (birthnumber != null) {
            birthnumber = birthnumber.trim();
            if (birthnumber.equalsIgnoreCase(""))
                birthnumber = null;
        }

        List<Identity> identList = identityservicebean.findIdentitiesByParams(
                firstname, lastname, isMale, birthnumber);

        Map<Integer, List<Identity>> map = new HashMap<Integer, List<Identity>>();
        for (Identity ident : identList) {
            if (!map.containsKey(ident.getIdperson())) {
                map.put(ident.getIdperson(), new ArrayList<Identity>());
            }
            map.get(ident.getIdperson()).add(ident);

        }

        List<Identity> listIden = new ArrayList<Identity>();

        for (List<Identity> lI : map.values()) {
            listIden.addAll(lI);
        }
        return listIden;
    }

    public void filterPersons() {
        filterOn = true;
        foundIdentities = searchIdentities();
    }

    public void cancelFilter() {
        filterOn = false;
        foundIdentities = null;
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

    public Boolean getFilterOn() {
        return filterOn;
    }

    public List<Identity> getFoundIdentities() {
        return foundIdentities;
    }
}
