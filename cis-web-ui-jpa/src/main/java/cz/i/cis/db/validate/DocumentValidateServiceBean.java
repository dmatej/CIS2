package cz.i.cis.db.validate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.i.cis.db.entities.Tdudocument;

@Stateless
@Named
public class DocumentValidateServiceBean implements Serializable,
        DocumentValidateService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "cis")
    private EntityManager em;

    public DocumentValidateServiceBean() {
    }

    @Override
    public String[] validate(Tdudocument document) {
        List<String> err = new ArrayList<String>();
        if (document.getValidto() == null)
            err.add("VALIDTO in DOCUMENT cannot be null!");

        if (document.getValidfrom() == null)
            err.add("VALIDFROM in DOCUMENT cannot be null!");

        if (document.getIdcodedocumenttype() == null)
            err.add("IDCODEDOCUMENTTYPE in DOCUMENT cannot be null!");

        if (document.getIdidentity() == null)
            err.add("IDIDENTITY in DOCUMENT cannot be null!");

        if (document.getIdperson() == null)
            err.add("IDPERSON in DOCUMENT cannot be null!");

        if (err.size() == 0)
            return null;
        String[] errs = new String[err.size()];
        errs = err.toArray(errs);
        return errs;
    }

}
