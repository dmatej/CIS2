/**
 *
 */
package cz.i.cis.code;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import cz.i.cis.db.code.CodeService;
import cz.i.cis.db.entities.CodeDocumenttype;
import cz.i.cis.db.entities.CodePermissiontype;
import cz.i.cis.db.entities.CodePurposeofstay;
import cz.i.cis.db.entities.CodeState;

/**
 * Beana pro práci s číselníky ve formulářích.
 *
 * @author Jan Šváb
 *
 */
@Named("codes")
@SessionScoped
public class CodesBean implements Serializable {
  /** serial version id */
  private static final long serialVersionUID = 1L;

  /** servisní beana pro číselníky */
  @EJB
  private CodeService codeservicebean;

  /** mapa pro cachování států */
  private Map<Integer, CodeState> states;

  /** mapa pro cachování důvodů pobytu */
  private Map<Integer, CodePurposeofstay> purposesofstay;

  /** mapa pro cachování typů povolení pobytu */
  private Map<Integer, CodePermissiontype> permissiontypes;

  /** mapa pro cachování typů dokumentů */
  private Map<Integer, CodeDocumenttype> documenttypes;

  /**
   * Naplní cachovací tabulky pro jednotlivé číselníky.
   */
  @PostConstruct
  private void createSession() {
    states = new HashMap<Integer, CodeState>();
    purposesofstay = new HashMap<Integer, CodePurposeofstay>();
    permissiontypes = new HashMap<Integer, CodePermissiontype>();
    documenttypes = new HashMap<Integer, CodeDocumenttype>();

    List<CodeState> listStates = codeservicebean.findStates();
    for (CodeState cs : listStates)
      states.put(cs.getId(), cs);

    List<CodePurposeofstay> purpofstay = codeservicebean.findPurposeOfStays();
    for (CodePurposeofstay cps : purpofstay)
      purposesofstay.put(cps.getId(), cps);

    List<CodePermissiontype> permtypes = codeservicebean.findPermissionTypes();
    for (CodePermissiontype pt : permtypes)
      permissiontypes.put(pt.getId(), pt);

    List<CodeDocumenttype> doctypes = codeservicebean.findDocumentTypes();
    for (CodeDocumenttype dt : doctypes)
      documenttypes.put(dt.getId(), dt);
  }

  /**
   * Vrátí stát dle id.
   *
   * @param id
   *          id státu
   * @return hledaný stát
   */
  public CodeState findState(Integer id) {
    return states.get(id);
  }

  /**
   * Vrátí důvod pobytu dle id.
   *
   * @param id
   *          id důvodu pobytu
   * @return hledaný důvod pobytu
   */
  public CodePurposeofstay findPurposeOfStay(Integer id) {
    return purposesofstay.get(id);
  }

  /**
   * Vrátí povolení pobytu dle id.
   *
   * @param id
   *          id povolení pobytu
   * @return hledané povolení pobytu
   */
  public CodePermissiontype findPermissionType(Integer id) {
    return permissiontypes.get(id);
  }

  /**
   * Vrátí typ dokumentu dle id.
   *
   * @param id
   *          id typu dokumentu
   * @return hledaný typ dokumentu
   */
  public CodeDocumenttype findDocumentType(Integer id) {
    return documenttypes.get(id);
  }

  /**
   * Vrátí list všech států.
   *
   * @return list všech států
   */
  public Collection<CodeState> listStates() {
    return states.values();
  }

  /**
   * Vrátí list všech důvodů pobytu.
   *
   * @return list všech důvodů pobytu
   */
  public Collection<CodePurposeofstay> listPurposesofstay() {
    return purposesofstay.values();
  }

  /**
   * Vrátí list všech typů povolení pobytu.
   *
   * @return list všech typů povolení pobytu
   */
  public Collection<CodePermissiontype> listPermissiontypes() {
    return permissiontypes.values();
  }

  /**
   * Vrátí list všech typů dokumentů.
   *
   * @return list všech typů dokumentů
   */
  public Collection<CodeDocumenttype> listDocumenttypes() {
    return documenttypes.values();
  }

}
