package cz.i.cis.db.person;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tduperson;

/**
 * Beana pro slučování person do jedné.
 *
 * @author Martin Štulc
 *
 */
@Local(CollapsePersonService.class)
public interface CollapsePersonService {
  /**
   * Sloučí dvě persony do jedné tak, že pokud mají atribut vyplněný obě
   * persony, veme se ten z mainPerson.
   *
   * @param mainPerson
   *          slučovaná persona
   * @param importedPerson
   *          slučovaná persona
   * @return mainPerson obohacená o parametry a identity importedPerson
   */
  Tduperson collapsePersons(Tduperson mainPerson,
      Tduperson importedPerson);

}
