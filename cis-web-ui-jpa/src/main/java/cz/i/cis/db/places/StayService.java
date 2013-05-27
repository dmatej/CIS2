package cz.i.cis.db.places;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdustay;

/**
 * Beana pro práci s pobyty.
 *
 * @author Martin Štulc
 *
 */
@Local
public interface StayService {
  /**
   * Vytvoří pobyt v databázi.
   *
   * @param stay
   *          vytvářený pobyt
   * @return vytvořený pobyt
   */
  public Tdustay create(Tdustay stay);

  /**
   * Upraví pobyt v databázi.
   *
   * @param stay
   *          upravovaný pobyt
   * @return upravený pobyt
   */
  public Tdustay update(Tdustay stay);

  /**
   * Smaže pobyt v databázi (označí jako smazaný).
   *
   * @param stay
   *          mazaný pobyt
   * @return smazaný pobyt
   */
  public Tdustay delete(Tdustay stay);

  /**
   * Vrátí list pobytů pro danou personu.
   *
   * @param idPerson
   *          id persony
   * @return list pobytů pro danou personu
   */
  public List<Tdustay> listStaysForPerson(Integer idPerson);

  /**
   * Vrátí pobyt dle jeho id.
   *
   * @param id
   *          id pobytu
   * @return nalezný pobyt
   */
  public Tdustay findStayById(Integer id);
}
