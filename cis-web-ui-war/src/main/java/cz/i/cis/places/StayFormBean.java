package cz.i.cis.places;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.entities.Tduperson;
import cz.i.cis.db.entities.Tdustay;
import cz.i.cis.db.person.PersonService;
import cz.i.cis.db.places.StayService;
import cz.i.cis.db.validate.StayValidateService;
import cz.i.cis.other.Constants;

/**
 * Beana pro práci s pobyty ve formuláři.
 *
 * @author Martin Štulc, Jan Šváb
 *
 */
@Named("stay")
@RequestScoped
public class StayFormBean implements Serializable {
  /** serial version id */
  private static final long serialVersionUID = 1L;

  /** beana pro práci s pobytama */
  @EJB
  private StayService stayServiceBean;

  /** beana pro validaci pobytů */
  @EJB
  private StayValidateService stayValidateServicebean;

  /** beana pro práci s osobama */
  @EJB
  private PersonService personServiceBean;

  /** id aktuálního pobytu */
  private Integer id;

  /** datum udělení pobytu od */
  private Date grantedfrom;

  /** datum udělení pobytu do */
  private Date grantedto;

  /** id persony */
  private Integer idperson;

  /** poznámka */
  private String note;

  /** referenční číslo pobytu */
  private String refnumber;

  /** id účelu pobytu */
  private Integer idpobytucel;

  /** true, pokud je pobyt nastavený jako aktuální; jinak false */
  private Boolean asActual = false;

  /**
   * Vytvoří pobyt.
   *
   * @return url detailu pobytu
   */
  public String createStay() {
    if (!testBeans())
      return null;

    Tdustay stay = generateEntity();

    String[] validate = stayValidateServicebean.validate(stay);
    if (validate == null) {
      stay = stayServiceBean.create(stay);

      if (asActual) {
        Tduperson p = personServiceBean.findPersonById(idperson);
        p.setIdstayplaceActual(null);
        p.setIdstayActual(stay.getId());
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
   * Vytvoří z formuláře entitu pobytu.
   *
   * @return entita pobytu
   */
  private Tdustay generateEntity() {
    Tdustay stay = new Tdustay();
    stay.setGrantedfrom(grantedfrom);
    stay.setGrantedto(grantedto);
    stay.setIdperson(idperson);
    stay.setNote(note);
    stay.setRefnumber(refnumber);
    stay.setIdpobytucel(idpobytucel);
    return stay;
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
    grantedfrom = null;
    grantedto = null;
    note = null;
    refnumber = null;
    idpobytucel = null;
  }

  /**
   * Vrací list pobytů pro danou personu.
   *
   * @param idPerson
   *          id persony
   * @return list pobytů
   */
  public List<Tdustay> listStaysForPerson(Integer idPerson) {
    if (!testBeans())
      return null;

    return stayServiceBean.listStaysForPerson(idPerson);
  }

  /**
   * Otestuje dostupnost potřebných bean.
   *
   * @return true, pokud jse vše ok.
   */
  private boolean testBeans() {
    if (stayServiceBean == null) {
      FacesMessage message = new FacesMessage("stayServiceBean null!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return false;
    }

    if (stayValidateServicebean == null) {
      FacesMessage message = new FacesMessage("stayValidateServiceBean null!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return false;
    }

    return true;
  }

  /**
   * @return id aktuálního pobytu
   */
  public Integer getId() {
    return id;
  }

  /**
   * Nastaví id aktuálního pobytu.
   *
   * @param id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return datum pobolení pobytu od
   */
  public Date getGrantedfrom() {
    return grantedfrom;
  }

  /**
   * Nastaví datum povolení pobytu od
   *
   * @param grantedfrom
   *          povolení pobytu od
   */
  public void setGrantedfrom(Date grantedfrom) {
    this.grantedfrom = grantedfrom;
  }

  /**
   * @return datum povolení pobytu do
   */
  public Date getGrantedto() {
    return grantedto;
  }

  /**
   * Nastaví datum povolení pobytu do.
   *
   * @param grantedto
   *          datum povolení pobytu do
   */
  public void setGrantedto(Date grantedto) {
    this.grantedto = grantedto;
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
   * @return referenční číslo
   */
  public String getRefnumber() {
    return refnumber;
  }

  /**
   * Nastaví referenční číslo.
   *
   * @param refnumber
   *          referenční číslo
   */
  public void setRefnumber(String refnumber) {
    this.refnumber = refnumber;
  }

  /**
   * @return id účelu pobytu
   */
  public Integer getIdpobytucel() {
    return idpobytucel;
  }

  /**
   * Nastaví od účelu pobytu.
   *
   * @param idpobytucel
   *          id účelu pobytu
   */
  public void setIdpobytucel(Integer idpobytucel) {
    this.idpobytucel = idpobytucel;
  }

  /**
   * @return true, pokud je pobyt nastavený jako aktuální; jinak false
   */
  public Boolean getAsActual() {
    return asActual;
  }

  /**
   * Nastaví aktuálnost pobytu
   *
   * @param asActual
   *          true, pokud je pobyt nastavený jako aktuální; jinak false
   */
  public void setAsActual(Boolean asActual) {
    this.asActual = asActual;
  }
}
