package cz.i.cis.db.validate;

import javax.ejb.Local;

import cz.i.cis.db.entities.Identity;

/**
 * Beana pro validaci identity.
 *
 * @author Martin Štulc
 *
 */
@Local(IdentityValidateService.class)
public interface IdentityValidateService {
  /**
   * Zvaliduje identitu a vrátí seznam chyb.
   *
   * @param validovaná
   *          identita
   *
   * @return seznam chybových hlášek
   */
  public String[] validate(Identity identity);
}
