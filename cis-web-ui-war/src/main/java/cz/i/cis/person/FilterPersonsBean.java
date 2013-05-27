package cz.i.cis.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.person.IdentityService;

/**
 * Beana pro filtrování osob.
 *
 * @author Jan Šváb
 *
 */
@Named("filterpersons")
@RequestScoped
public class FilterPersonsBean {
  /** beana pro práci s identitama */
  @EJB
  private IdentityService identityservicebean;

  /** křestní jeméno */
  private String firstname;

  /** příjmení */
  private String lastname;

  /** datum narození */
  private String birthnumber = null;

  /** pohlaví */
  private String sex;

  /** true, pokud je filtr zapnutý; jinak false */
  private Boolean filterOn = false;

  /** nalezené identity */
  private List<Identity> foundIdentities;

  /**
   * Nalezne identity dle parametrů.
   *
   * @return list nalezených identit
   */
  private List<Identity> searchIdentities() {
    Boolean isMale = null;
    if (sex != null) {
      if (sex.equalsIgnoreCase("M"))
        isMale = true;
      else if (sex.equalsIgnoreCase("Z"))
        isMale = false;
    }

    if (birthnumber != null) {
      birthnumber = birthnumber.trim();
      if (birthnumber.equalsIgnoreCase(""))
        birthnumber = null;
    }

    List<Identity> identList = identityservicebean.findIdentitiesByParams(
        firstname, lastname, isMale, birthnumber);

    Map<Integer, List<Identity>> map = new HashMap<Integer, List<Identity>>();
    for (Identity ident : identList) {
      if (!map.containsKey(ident.getIdperson())) {
        map.put(ident.getIdperson(), new ArrayList<Identity>());
      }
      map.get(ident.getIdperson()).add(ident);

    }

    List<Identity> listIden = new ArrayList<Identity>();

    for (List<Identity> lI : map.values()) {
      listIden.addAll(lI);
    }
    return listIden;
  }

  /**
   * Vyfiltruje persony dle parametrů.
   */
  public void filterPersons() {
    filterOn = true;
    foundIdentities = searchIdentities();
  }

  /**
   * Zruší filtrování.
   */
  public void cancelFilter() {
    filterOn = false;
    foundIdentities = null;
  }

  /**
   * @return křestní jméno ve filtru
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * Nastaví křestní jméno do filtru.
   *
   * @param firstname
   *          křestní jméno
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * @return příjmení ve filtru
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * Nastaví příjmení do filtru.
   *
   * @param lastname
   *          příjmení
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * @return datum narození ve filtru
   */
  public String getBirthnumber() {
    return birthnumber;
  }

  /**
   * Nastaví datum narození do filtru
   *
   * @param birthnumber
   *          datum narození
   */
  public void setBirthnumber(String birthnumber) {
    this.birthnumber = birthnumber;
  }

  /**
   * @return pohlaví - M=muž; Z=žena - ve filtru
   */
  public String getSex() {
    return sex;
  }

  /**
   * Nastaví pohlaví do filtru.
   *
   * @param sex
   *          pohlaví
   */
  public void setSex(String sex) {
    this.sex = sex;
  }

  /**
   * @return vrací zda je filtr zapnut či vypnut
   */
  public Boolean getFilterOn() {
    return filterOn;
  }

  /**
   * Vrací nalezené identity
   *
   * @return list identit
   */
  public List<Identity> getFoundIdentities() {
    return foundIdentities;
  }
}
