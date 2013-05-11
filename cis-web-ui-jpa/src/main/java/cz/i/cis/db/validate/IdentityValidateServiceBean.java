package cz.i.cis.db.validate;

import java.io.Serializable;

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
    public Boolean validate(Identity identity) {
        if (identity.getBirthplace() == null)
            return false;
        if (identity.getOthernames() == null)
            return false;
        if (identity.getBirthname() == null)
            return false;
        if (identity.getFirstname() == null)
            return false;
        if (identity.getRstatus() == null)
            return false;
        if (identity.getIdstateofbirth() == null)
            return false;
        if (identity.getIdstate() == null)
            return false;
        if (identity.getSex() != null && identity.getSex().length() != 1)
            return false;
        if (identity.getBirthdate() == null)
            return false;
        if (identity.getIdorgunit() == null)
            return false;
        if (identity.getIdevidence() == null)
            return false;

        if (identity.getBirthnumber() == null
                || identity.getBirthnumber().length() != 10)
            return false;
        try {
            int birthnumber = Integer.parseInt(identity.getBirthnumber()
                    .substring(0, 4) + identity.getBirthnumber().substring(5));
            if (birthnumber % 11 != 0)
                return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
