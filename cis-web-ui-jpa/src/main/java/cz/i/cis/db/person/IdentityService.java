package cz.i.cis.db.person;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Identity;

/**
 * Beana pro práci s identitami.
 *
 * @author Martin Štulc
 *
 */
@Local
public interface IdentityService {
  /**
   * Vytvoří v databázi identitu.
   *
   * @param identity
   *          vytvážená identita
   * @return vytvořená identita
   */
  Identity create(Identity identity);

  /**
   * Upraví v databázi identitu.
   *
   * @param identity
   *          upravovaná identita
   * @return upravená identita
   */
  Identity update(Identity identity);

  /**
   * Smaže v databázi identitu (označí jako smazanou).
   *
   * @param identity
   *          mazaná identita
   * @return smazaná identita
   */
  Identity delete(Identity identity);

  /**
   * Vrátí list identit dané persony.
   *
   * @param idPerson
   *          id persony
   * @return list identit dané persony
   */
  List<Identity> findIdentitiesForPerson(Integer idPerson);

  /**
   * Nalezne identitu dle zadaných parametrů, pokud parametr nechceme využít
   * zadáme null.
   *
   * @param firstName
   *          křestní jméno
   * @param lastName
   *          příjmení
   * @param isMale
   *          true, pokud je hledaný muž, jenak false
   * @param birthNumber
   *          rodné číslo bez lomítka
   * @return list nalezených identit
   */
  List<Identity> findIdentitiesByParams(String firstName, String lastName,
      Boolean isMale, String birthNumber);

  /**
   * Vrátí list všech hlavních identit, všech osob.
   *
   * @return list všech hlavních identit, všech osob
   */
  List<Identity> findActualIdentitiesOfPersons();

  /**
   * Vrátí identitu dle její id.
   *
   * @param idIdentity
   *          id identity
   * @return nalezená identita
   */
  Identity findIdentityById(Integer idIdentity);

}
