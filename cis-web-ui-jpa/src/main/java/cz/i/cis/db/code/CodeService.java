package cz.i.cis.db.code;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.CodeDocumenttype;
import cz.i.cis.db.entities.CodePermissiontype;
import cz.i.cis.db.entities.CodePurposeofstay;
import cz.i.cis.db.entities.CodeState;

/**
 * Beana, která hledá v číselnících
 *
 * @author Martin Štulc
 *
 */
@Local
public interface CodeService {
  /**
   * Vrací typ dokumentu v závislosti na jeho id.
   *
   * @param id
   *          id číselníku
   * @return typ dokumentu
   */
  CodeDocumenttype findDocumentTypeById(Integer id);

  /**
   * Vrací typ povolení pobytu v závislosti na jeho id.
   *
   * @param id
   *          id číselníku
   * @return typ povolení pobytu
   */
  CodePermissiontype findPermissionTypeById(Integer id);

  /**
   * Vrací důvod pobytu v závislosti na jeho id.
   *
   * @param id
   *          id číselníku
   * @return důvod pobytu
   */
  CodePurposeofstay findPurposeOfStayById(Integer id);

  /**
   * Vrací stát v závislosti na jeho id.
   *
   * @param id
   *          id číselníku
   * @return stát
   */
  CodeState findStateById(Integer id);

  /**
   * Vrací list všech typů dokumentu.
   *
   * @return list všech typů dokumentu
   */
  List<CodeDocumenttype> findDocumentTypes();

  /**
   * Vrací list všech typů povolení pobytu.
   *
   * @return list všech povolení pobytu
   */
  List<CodePermissiontype> findPermissionTypes();

  /**
   * Vrací list všech důvodů pobytu.
   *
   * @return list všech důvodů pobytu
   */
  List<CodePurposeofstay> findPurposeOfStays();

  /**
   * Vrací list všech států.
   *
   * @return list všech států
   */
  List<CodeState> findStates();

}
