package cz.i.cis.db.validate;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdudocument;

/**
 * Beana pro validaci dokumentu.
 *
 * @author Martin Štulc
 *
 */
@Local(DocumentValidateService.class)
public interface DocumentValidateService {
  /**
   * Zvaliduje dokument a vrátí seznam chyb.
   * 
   * @param validovaný
   *          dokument
   * @return seznam chybových hlášek
   */
  public String[] validate(Tdudocument document);
}
