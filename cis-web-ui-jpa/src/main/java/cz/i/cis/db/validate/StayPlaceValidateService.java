package cz.i.cis.db.validate;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdustayplace;

/**
 * Beana pro validaci místa pobytu.
 *
 * @author Martin Štulc
 *
 */
@Local(StayPlaceValidateService.class)
public interface StayPlaceValidateService {
  /**
   * Zvaliduje místo pobytu a vrátí seznam chyb.
   *
   * @param validované
   *          místo pobytu
   * @return seznam chybových hlášek
   */
  public String[] validate(Tdustayplace stayPlace);
}
