package cz.i.cis.db.validate;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdustay;

/**
 * Beana pro validaci pobytu.
 *
 * @author Martin Štulc
 *
 */
@Local(StayValidateService.class)
public interface StayValidateService {
  /**
   * Zvaliduje pobyt a vrátí seznam chyb.
   *
   * @param validovaný
   *          pobyt
   * @return seznam chybových hlášek
   */
  public String[] validate(Tdustay stay);
}
