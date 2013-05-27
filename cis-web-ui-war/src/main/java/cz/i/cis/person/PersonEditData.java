/**
 *
 */
package cz.i.cis.person;

import java.util.Date;
import java.util.List;

import cz.i.cis.db.entities.Tdustay;
import cz.i.cis.db.entities.Tdustayplace;

/**
 * Obsahuje editovana data osoby ve formulari.
 */
public class PersonEditData {

  /**
   * Titul pred jmenem
   */
  private String degreeprefix;
  /**
   * Titul za jmenem
   */
  private String degreesuffix;
  /**
   * Poznamka
   */
  private String note;
  /**
   * Datum umrti
   */
  private Date deathdate;
  /**
   * Misto smrti
   */
  private String deathplace;
  /**
   * ID mista smrti
   */
  private Integer iddeathplace;
  /**
   * ID statu smrti
   */
  private Integer iddeathstate;
  /**
   * ID aktualniho pobytu
   */
  private Integer idstayActual;
  /**
   * ID aktualniho mista pobytu
   */
  private Integer idstayplaceActual;
  /**
   * Seznam pobytu osoby pro vyber
   */
  private List<Tdustay> listStays;
  /**
   * Seznam mist pobytu pro vyber
   */
  private List<Tdustayplace> listStayPlaces;


  /**
   * @return Vraci titul pred jmenem.
   */
  public String getDegreeprefix() {
    return degreeprefix;
  }


  /**
   * Nastavuje titul pred jmenem.
   *
   * @param degreeprefix Titul pred jmenem
   */
  public void setDegreeprefix(String degreeprefix) {
    this.degreeprefix = degreeprefix;
  }


  /**
   * @return Vraci titul za jmenem.
   */
  public String getDegreesuffix() {
    return degreesuffix;
  }


  /**
   * Nastavuje titul za jmenem.
   *
   * @param degreesuffix Titul za jmenem
   */
  public void setDegreesuffix(String degreesuffix) {
    this.degreesuffix = degreesuffix;
  }


  /**
   * @return Vraci poznamku k osobe.
   */
  public String getNote() {
    return note;
  }


  /**
   * Nastavuje poznamku.
   *
   * @param note Titul Poznamka
   */
  public void setNote(String note) {
    this.note = note;
  }


  /**
   * @return Vraci datum umrti.
   */
  public Date getDeathdate() {
    return deathdate;
  }


  /**
   * Nastavuje datum umrti.
   *
   * @param deathdate Datum umrti
   */
  public void setDeathdate(Date deathdate) {
    this.deathdate = deathdate;
  }


  /**
   * @return Vraci misto umrti osoby.
   */
  public String getDeathplace() {
    return deathplace;
  }


  /**
   * Nastavuje misto umrti.
   *
   * @param deathplace Misto umrti
   */
  public void setDeathplace(String deathplace) {
    this.deathplace = deathplace;
  }


  /**
   * @return Vraci ID mista mista umrti.
   */
  public Integer getIddeathplace() {
    return iddeathplace;
  }


  /**
   * Nastavuje ID mista umrti.
   *
   * @param iddeathplace ID mista umrti
   */
  public void setIddeathplace(Integer iddeathplace) {
    this.iddeathplace = iddeathplace;
  }


  /**
   * @return Vraci ID statu umrti.
   */
  public Integer getIddeathstate() {
    return iddeathstate;
  }


  /**
   * Nastavuje ID statu umrti
   *
   * @param iddeathstate ID statu umrti
   */
  public void setIddeathstate(Integer iddeathstate) {
    this.iddeathstate = iddeathstate;
  }


  /**
   * @return Vraci ID aktualniho pobytu.
   */
  public Integer getIdstayActual() {
    return idstayActual;
  }


  /**
   * Nastavuje ID aktualniho pobytu.
   *
   * @param idstayActual ID aktualniho pobytu
   */
  public void setIdstayActual(Integer idstayActual) {
    this.idstayActual = idstayActual;
  }


  /**
   * @return Vraci ID aktualniho mista pobytu.
   */
  public Integer getIdstayplaceActual() {
    return idstayplaceActual;
  }


  /**
   * Nastavuje ID aktualniho mista pobytu.
   *
   * @param idstayplaceActual ID aktualniho mista pobytu
   */
  public void setIdstayplaceActual(Integer idstayplaceActual) {
    this.idstayplaceActual = idstayplaceActual;
  }


  /**
   * @return Vraci seznam moznych pobytu osoby.
   */
  public List<Tdustay> getListStays() {
    return listStays;
  }


  /**
   * Nastavuje seznam pobytu.
   *
   * @param listStays Seznam pobytu
   */
  public void setListStays(List<Tdustay> listStays) {
    this.listStays = listStays;
  }


  /**
   * @return Vraci seznam mist pobytu osoby.
   */
  public List<Tdustayplace> getListStayPlaces() {
    return listStayPlaces;
  }


  /**
   * Nastavuje seznam moznych mist pobytu.
   *
   * @param listStayPlaces Seznam mist pobytu
   */
  public void setListStayPlaces(List<Tdustayplace> listStayPlaces) {
    this.listStayPlaces = listStayPlaces;
  }
}
