package cz.i.cis.person;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import cz.i.cis.db.code.CodeService;
import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.person.PersonService;
import cz.i.cis.other.Constants;

/**
 * Třída pro zbrazení osob.
 *
 * @author Jan Šváb
 *
 */
@Named("personsview")
@RequestScoped
public class PersonsViewBean implements Serializable {
  private static final long serialVersionUID = 1L;

  /** beana pro práci s osobama */
  @EJB
  private PersonService personservicebean;

  /** beana pro práci s identitama */
  @EJB
  private IdentityService identityservicebean;

  /** beana pro práci s číselníkama */
  @EJB
  private CodeService codeservicebean;

  /**
   * Vrací list hlavních identit osob.
   *
   * @return list hlavních identit osob
   */
  public List<Identity> listPersonsByActualIdentities() {

    return identityservicebean.findActualIdentitiesOfPersons();
  }

  /**
   * Formátuje pohlaví pro potřeby zobrazení.
   *
   * @param sex
   *          pohlaví
   * @return zobrazené pohlaví
   */
  public String formatSex(String sex) {
    if (sex.equalsIgnoreCase("M"))
      return "Muž";
    else if (sex.equalsIgnoreCase("Z"))
      return "Žena";

    return "-";
  }

  /**
   * Vrací url detalu osoby.
   *
   * @return url detailu osoby
   */
  public String outcome() {
    return Constants.PAGE_VIEW_DETAIL;
  }
}
