package cz.i.cis.db.documents;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdudocument;

/**
 * Beana pro práci s dokumenty
 *
 * @author Martin Štulc
 *
 */
@Local
public interface DocumentService {
  /**
   * Vytvoří dokument v databázi.
   *
   * @param dokument
   *          vytvářený dokument
   * @return vytvořený dokument
   */
  Tdudocument create(Tdudocument document);

  /**
   * Upraví dokument v databázi.
   *
   * @param dokument
   *          upravovaný dokument
   * @return upravený dokument
   */
  Tdudocument update(Tdudocument document);

  /**
   * Smaže dokument v databázi (označí jako smazaný).
   *
   * @param dokument
   *          mazaný dokument
   * @return smazaný dokument
   */
  Tdudocument delete(Tdudocument document);

  /**
   * Vrací list všech dokumentů pro danou personu.
   *
   * @param idPerson
   *          id persony pro kterou se hledají dokumenty
   * @return list všech dokumentů pro danou personu
   */
  List<Tdudocument> findDocumentsForPerson(Integer idPerson);

  /**
   * Vrátí dokument dle jeho id.
   *
   * @param id
   *          id dokumentu
   * @return dokument
   */
  Tdudocument findDocumentsById(Integer id);

}
