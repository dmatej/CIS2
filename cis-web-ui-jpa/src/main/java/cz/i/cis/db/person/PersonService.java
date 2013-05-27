package cz.i.cis.db.person;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tduperson;

/**
 * Beana pro práci s personou.
 *
 * @author Martin Štulc
 *
 */
@Local(PersonService.class)
public interface PersonService {
  /**
   * Vytvoří personu v databázi.
   *
   * @param person
   *          vytvářená persona
   * @return vytvořená persona
   */
  public Tduperson create(Tduperson person);

  /**
   * Upraví personu v databázi.
   *
   * @param person
   *          upravovaná persona
   * @return upravená persona
   */
  public Tduperson update(Tduperson person);

  /**
   * Smaže personu v databázi (označí jako smazanou).
   *
   * @param person
   *          mazaná persona
   * @return smazaná persona
   */
  public Tduperson delete(Tduperson person);

  /**
   * Vrací list všech person.
   *
   * @return list všech person
   */
  public List<Tduperson> findPersons();

  /**
   * Vrátí personu dle jejího id
   *
   * @param id
   *          id persony
   * @return nalezená persona
   */
  public Tduperson findPersonById(Integer id);
}
