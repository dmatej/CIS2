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

@Named("codes")
@SessionScoped
public class CodesBean implements Serializable {

  private static final long serialVersionUID = 1L;

  @EJB
  private CodeService codeservicebean;

  private Map<Integer, CodeState> states;

  private Map<Integer, CodePurposeofstay> purposesofstay;

  private Map<Integer, CodePermissiontype> permissiontypes;

  private Map<Integer, CodeDocumenttype> documenttypes;

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

  public CodeState findState(Integer id) {
    return states.get(id);
  }

  public CodePurposeofstay findPurposeOfStay(Integer id) {
    return purposesofstay.get(id);
  }

  public CodePermissiontype findPermissionType(Integer id) {
    return permissiontypes.get(id);
  }

  public CodeDocumenttype findDocumentType(Integer id) {
    return documenttypes.get(id);
  }

  public Collection<CodeState> listStates() {
    return states.values();
  }

  public Collection<CodePurposeofstay> listPurposesofstay() {
    return purposesofstay.values();
  }

  public Collection<CodePermissiontype> listPermissiontypes() {
    return permissiontypes.values();
  }

  public Collection<CodeDocumenttype> listDocumenttypes() {
    return documenttypes.values();
  }


}
