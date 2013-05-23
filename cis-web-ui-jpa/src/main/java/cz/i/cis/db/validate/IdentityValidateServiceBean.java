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
    if (identity.getSex() != null && identity.getSex().length() != 1)
      err.add("SEX in IDENTITY must have one char!");

    // TODO [stulc] validace birthdate

    if (identity.getBirthnumber() != null) {

      if (identity.getBirthnumber().length() != 10)
        err.add("BIRTHNUMBER in IDENTITY must have 10 chars!");
      else
        try {
          long birthnumber = Long.parseLong(identity.getBirthnumber());
          if (birthnumber % 11 != 0)
            err.add("BIRTHNUMBER in IDENTITY must be divisible by 11 without remainder!");
        } catch (NumberFormatException e) {
          err.add("BIRTHNUMBER in IDENTITY must be in format XXXXXXXXXX where X is a number!");
        }
    }
    if (err.size() == 0)
      return null;
    String[] errs = new String[err.size()];
    errs = err.toArray(errs);
    return errs;
  }

}
