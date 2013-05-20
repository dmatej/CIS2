package cz.i.cis.db.validate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.i.cis.db.entities.Tdustay;

@Stateless
@Named
public class StayValidateServiceBean implements Serializable,
        StayValidateService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "cis")
    private EntityManager em;

    public StayValidateServiceBean() {
    }

    @Override
    public String[] validate(Tdustay stay) {
        List<String> err = new ArrayList<String>();

        if (stay.getGrantedfrom() == null)
            err.add("GRANTEDFROM in STAY cannot be null!");

        if (stay.getGrantedto() == null)
            err.add("GRANTEDTO in STAY cannot be null!");


        if (err.size() == 0)
            return null;
        String[] errs = new String[err.size()];
        errs = err.toArray(errs);
        return errs;
    }

}
