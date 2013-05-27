package cz.i.cis.db.places;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdustayplace;

/**
 * Beana pro práci s místy pobytu.
 *
 * @author Martin Štulc
 *
 */
@Local
public interface StayPlaceService {
  /**
   * Vytvoří místo pobytu v databázi.
   *
   * @param stayPlace
   *          vytvářené místo pobytu
   * @return vytvořené místo pobytu
   */
  public Tdustayplace create(Tdustayplace stayPlace);

  /**
   * Upraví místo pobytu v databázi.
   *
   * @param stayPlace
   *          upravované místo pobytu
   * @return upravené místo pobytu
   */
  public Tdustayplace update(Tdustayplace stayPlace);

  /**
   * Zmaže místo pobytu v databázi (označí jako smazané).
   *
   * @param stayPlace
   *          mazané místo pobytu
   * @return smazané místo pobytu
   */
  public Tdustayplace delete(Tdustayplace stayPlace);

  /**
   * Vrátí list míst pobytu dané persony.
   *
   * @param idPerson
   *          id persony
   * @return list míst pobytu dané persony
   */
  public List<Tdustayplace> findStayPlacesForPerson(Integer idPerson);

  /**
   * Vrátí list míst pobytu daného pobytu.
   *
   * @param idStay
   *          id pobytu
   * @return list míst pobytu daného pobytu
   */
  public List<Tdustayplace> findStayPlacesForStay(Integer idStay);

  /**
   * Vrátí místo pobytu dle id.
   *
   * @param id
   *          id místa pobytu
   * @return nalezené místo pobytu
   */
  public Tdustayplace findStayPlaceById(Integer id);
}
