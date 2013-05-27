package cz.i.cis.places;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import cz.i.cis.db.entities.Tduperson;
import cz.i.cis.db.entities.Tdustay;
import cz.i.cis.db.entities.Tdustayplace;
import cz.i.cis.db.person.PersonService;
import cz.i.cis.db.places.StayPlaceService;
import cz.i.cis.db.places.StayService;
import cz.i.cis.db.validate.StayPlaceValidateService;
import cz.i.cis.other.Constants;

/**
*  Třída pro formulář s místem pobytu.
*
* @author Jan Šváb
*
*/
@ManagedBean(name = "stayplace")
@ViewScoped
public class StayPlaceFormBean implements Serializable {
  /** serial version id */
  private static final long serialVersionUID = 1L;

  /** beana pro práci s místy pobytu */
  @EJB
  private StayPlaceService stayPlaceServiceBean;

  /** beana pro práci s pobyty */
  @EJB
  private StayService stayServiceBean;

  /** beana pro práci s osobami */
  @EJB
  private PersonService personServiceBean;

  /** beana pro validaci místa pobytu */
  @EJB
  private StayPlaceValidateService stayPlaceValidateServicebean;

  /** datum od */
  private Date datefrom;

  /** datum do */
  private Date dateto;

  /** datum udělení */
  private Timestamp ddate;

  /** adresa */
  private String address;

  /** id persony */
  private Integer idperson;

  /** id pobytu */
  private Integer idtdustay;

  /** poznámka */
  private String note;

  /** true, pokud je místo pobytu aktuální; jinak false */
  private Boolean asActual = false;

  /**
   * Vytvoří místo pobytu.
   *
   * @return url detailu místa pobytu
   */
  public String createStayPlace() {
    if (!testBeans())
      return null;

    Tdustayplace stayPlace = new Tdustayplace();
    stayPlace.setDatefrom(datefrom);
    stayPlace.setDateto(dateto);
    stayPlace.setDdate(ddate);
    stayPlace.setAddress(address);
    stayPlace.setIdperson(idperson);
    stayPlace.setIdtdustay(idtdustay);
    stayPlace.setNote(note);

    String[] validate = stayPlaceValidateServicebean.validate(stayPlace);
    if (validate == null) {
      stayPlace = stayPlaceServiceBean.create(stayPlace);

      if (asActual) {
        Tduperson p = personServiceBean.findPersonById(idperson);
        p.setIdstayplaceActual(stayPlace.getId());
        p.setIdstayActual(stayPlace.getIdtdustay());
        personServiceBean.update(p);
      }

    } else {
      for (int i = 0; i < validate.length; i++) {
        FacesMessage message = new FacesMessage("Chyba při validaci pobytu! ("
            + validate[i] + ")");
        FacesContext.getCurrentInstance().addMessage(null, message);
      }
      return null;
    }

    return Constants.PAGE_VIEW_DETAIL
        + "?faces-redirect=true&amp;includeViewParams=true";
  }

  /**
   * Vrací místa pobytu pro danou osobu.
   *
   * @param idPerson
   *          od osoby
   * @return list míst pobytu
   */
  public List<Tdustayplace> getStayPlacesForPerson(Integer idPerson) {
    if (!testBeans())
      return null;

    return stayPlaceServiceBean.findStayPlacesForPerson(idPerson);
  }

  /**
   * Vrací místa pobytu pro daný pobyt.
   *
   * @param idStay
   *          id pobytu
   * @return list míst pobytu
   */
  public List<Tdustayplace> getStayPlacesForStay(Integer idStay) {
    if (!testBeans())
      return null;

    return stayPlaceServiceBean.findStayPlacesForStay(idStay);
  }

  /**
   * Vrací list pobytů pro personu.
   *
   * @return list pobytů
   */
  public List<Tdustay> listStays() {
    if (idperson == null)
      return new ArrayList<Tdustay>();

    return stayServiceBean.listStaysForPerson(idperson);
  }

  /**
   * Smaže formulář.
   */
  public void clearForm() {
    Map<String, String> params = FacesContext.getCurrentInstance()
        .getExternalContext().getRequestParameterMap();
    try {
      idperson = Integer.parseInt(params.get("personid"));
    } catch (Exception e) {
      idperson = null;
    }

    // for sure (thanks RequestScope are data deleted)

    datefrom = null;
    dateto = null;
    address = null;
    idtdustay = null;
    note = null;
  }

  /**
   * Otestuje dostupnost bean.
   *
   * @return true pokud je vše ok.
   */
  private boolean testBeans() {
    if (stayPlaceServiceBean == null) {
      FacesMessage message = new FacesMessage("stayPlaceServiceBean null!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return false;
    }

    if (stayPlaceValidateServicebean == null) {
      FacesMessage message = new FacesMessage(
          "stayPlaceValidateServicebean null!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return false;
    }

    return true;
  }

  /**
   * @return datum od
   */
  public Date getDatefrom() {
    return datefrom;
  }

  /**
   * Nastaví datum od
   *
   * @param datefrom
   *          datum od
   */
  public void setDatefrom(Date datefrom) {
    this.datefrom = datefrom;
  }

  /**
   * @return datum do
   */
  public Date getDateto() {
    return dateto;
  }

  /**
   * Nastaví datum do
   *
   * @param dateto
   *          datum do
   */
  public void setDateto(Date dateto) {
    this.dateto = dateto;
  }

  /**
   * @return adresa
   */
  public String getAddress() {
    return address;
  }

  /**
   * Nastaví adresu
   *
   * @param address
   *          adresa
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return poznámka
   */
  public String getNote() {
    return note;
  }

  /**
   * Nastaví poznámku.
   *
   * @param note
   *          poznámka
   */
  public void setNote(String note) {
    this.note = note;
  }

  /**
   * @return id persony
   */
  public Integer getIdperson() {
    return idperson;
  }

  /**
   * Nastaví id persony.
   *
   * @param idperson
   *          id persony
   */
  public void setIdperson(Integer idperson) {
    this.idperson = idperson;
  }

  /**
   * @return true, pokud je pobyt nasaven jako aktuální; jinak false
   */
  public Boolean getAsActual() {
    return asActual;
  }

  /**
   * Nastaví aktuálnost pobytu.
   *
   * @param asActual
   *          true, pokud je pobyt nasaven jako aktuální; jinak false
   */
  public void setAsActual(Boolean asActual) {
    this.asActual = asActual;
  }

  /**
   * @return id pobytu
   */
  public Integer getIdtdustay() {
    return idtdustay;
  }

  /**
   * Nastaví id pobytu.
   *
   * @param idtdustay
   *          id pobytu.
   */
  public void setIdtdustay(Integer idtdustay) {
    this.idtdustay = idtdustay;
  }
}