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
            err.add("BIRTHPLACE in IDENTITY cannot be null!");
        if (identity.getOthernames() == null)
            err.add("OTHERNAMES in IDENTITY cannot be null!");
        if (identity.getBirthname() == null)
            err.add("BIRTHNAME in IDENTITY cannot be null!");
        if (identity.getFirstname() == null)
            err.add("FIRSTNAME in IDENTITY cannot be null!");
        /*
         * if (identity.getRstatus() == null) return false; if
         * (identity.getIdstateofbirth() == null) return false; if
         * (identity.getIdstate() == null) return false;
         */
        if (identity.getSex() != null && identity.getSex().length() != 1)
            err.add("SEX in IDENTITY must has one char!");
        if (identity.getBirthdate() == null)
            err.add("BIRTHDAY in IDENTITY cannot be null!");
        /*
         * if (identity.getIdorgunit() == null) return false; if
         * (identity.getIdevidence() == null) return false;
         */

        if (identity.getBirthnumber() == null)
            err.add("BIRTHNUMBER in IDENTITY cannot be null!");

          if( identity.getBirthnumber().length() != 10)
            err.add("BIRTHNUMBER in IDENTITY must has 10 chars!");
        else
            try {
                long birthnumber = Long.parseLong(identity.getBirthnumber());
                if (birthnumber % 11 != 0)
                    err.add("BIRTHNUMBER in IDENTITY must be divisible by 11 without remainder!");
            } catch (NumberFormatException e) {
                err.add("BIRTHNUMBER in IDENTITY must be in format XXXXXXXXXX where X is a number!");
            }
        if (err.size() == 0)
            return null;
        String[] errs = new String[err.size()];
        errs = err.toArray(errs);
        return errs;
    }

}
