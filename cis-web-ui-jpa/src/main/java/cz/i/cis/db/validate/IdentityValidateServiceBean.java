package cz.i.cis.db.validate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.i.cis.db.entities.Identity;

@Stateless
@Named
public class IdentityValidateServiceBean implements Serializable,
        IdentityValidateService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "cis")
    private EntityManager em;

    public IdentityValidateServiceBean() {
    }

    @Override
    public String[] validate(Identity identity) {
        List<String> err = new ArrayList<String>();
        if (identity.getBirthplace() == null)
            err.add("birthPlace");
        if (identity.getOthernames() == null)
            err.add("otherNames");
        if (identity.getBirthname() == null)
            err.add("birthName");
        if (identity.getFirstname() == null)
            err.add("firstName");
        /*
         * if (identity.getRstatus() == null) return false; if
         * (identity.getIdstateofbirth() == null) return false; if
         * (identity.getIdstate() == null) return false;
         */
        if (identity.getSex() != null && identity.getSex().length() != 1)
            err.add("sex");
        if (identity.getBirthdate() == null)
            err.add("birthDate");
        /*
         * if (identity.getIdorgunit() == null) return false; if
         * (identity.getIdevidence() == null) return false;
         */

        if (identity.getBirthnumber() == null
                || identity.getBirthnumber().length() != 10)
            err.add("birthNumber");
        else
            try {
                int birthnumber = Integer.parseInt(identity.getBirthnumber()
                        .substring(0, 4)
                        + identity.getBirthnumber().substring(5));
                if (birthnumber % 11 != 0)
                    err.add("birthNumber");
            } catch (NumberFormatException e) {
                err.add("birthNumber");
            }
        if (err.size() == 0)
            return null;
        String[] errs = new String[err.size()];
        errs = err.toArray(errs);
        return errs;
    }

}
