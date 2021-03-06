package cz.i.cis.db.validate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.i.cis.db.entities.Tdustayplace;

@Stateless
@Named
public class StayPlaceValidateServiceBean implements Serializable,
    StayPlaceValidateService {

  /** serial version id */
  private static final long serialVersionUID = 1L;

  /** entity manager */
  @PersistenceContext(unitName = "cis")
  private EntityManager em;

  public StayPlaceValidateServiceBean() {
  }

  /** {@inheritDoc} */
  @Override
  public String[] validate(Tdustayplace stayPlace) {
    List<String> err = new ArrayList<String>();

    if (stayPlace.getDatefrom() == null)
      err.add("DATEFROM in STAYPLACE cannot be null!");

    if (stayPlace.getDateto() == null)
      err.add("DATETO in STAYPLACE cannot be null!");

    if (err.size() == 0)
      return null;

    String[] errs = new String[err.size()];
    errs = err.toArray(errs);
    return errs;
  }

}
