package cz.i.cis.db.validate;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.i.cis.db.entities.Tduperson;

@Stateless
@Named
public class PersonValidateServiceBean implements Serializable,
        PersonValidateService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "cis")
    private EntityManager em;

    public PersonValidateServiceBean() {
    }

    @Override
    public Boolean validate(Tduperson person) {
        if (person.getCdate() == null)
            return false;
        if (person.getRstatus() == null)
            return false;
        if (person.getUidcisuser() == null)
            return false;
        return true;
    }

}
