package cz.i.cis.db.validate;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tduperson;

/**
 * Beana pro validaci persony.
 *
 * @author Martin Štulc
 *
 */
@Local(PersonValidateService.class)
public interface PersonValidateService {
  /**
   * Zvaliduje personu a vrátí seznam chyb.
   *
   * @param validovaná
   *          persona
   * @return seznam chybových hlášek
   */
  public String[] validate(Tduperson person);
}
