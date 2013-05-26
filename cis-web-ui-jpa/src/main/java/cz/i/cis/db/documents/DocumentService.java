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
  public Tdudocument create(Tdudocument document);

  /**
   * Upraví dokument v databázi.
   *
   * @param dokument
   *          upravovaný dokument
   * @return upravený dokument
   */
  public Tdudocument update(Tdudocument document);

  /**
   * Upraví dokument v databázi.
   *
   * @param dokument
   *          upravovaný dokument
   * @return upravený dokument
   */
  public Tdudocument delete(Tdudocument document);

  /**
   * Vrací list všech dokumentů pro danou personu.
   *
   * @param idPerson
   *          id persony pro kterou se hledají dokumenty
   * @return list všech dokumentů pro danou personu
   */
  public List<Tdudocument> findDocumentsForPerson(Integer idPerson);

  /**
   * Vrátí dokument dle jeho id.
   *
   * @param id
   *          id dokumentu
   * @return dokument
   */
  public Tdudocument findDocumentsById(Integer id);

}
