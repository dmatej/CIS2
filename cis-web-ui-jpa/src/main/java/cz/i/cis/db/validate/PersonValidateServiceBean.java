package cz.i.cis.db.validate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    public String[] validate(Tduperson person) {
        List<String> err = new ArrayList<String>();
        if (err.size() == 0)
            return null;
        String[] errs = new String[err.size()];
        errs = err.toArray(errs);
        return errs;
    }

}
