package cz.i.cis.documents;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import cz.i.cis.db.documents.DocumentService;
import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.entities.Tdudocument;
import cz.i.cis.db.entities.Tdustay;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.places.StayService;
import cz.i.cis.db.validate.DocumentValidateService;
import cz.i.cis.other.Constants;

/**
 * Beana pro práci s dokumentem ve formuláři.
 *
 * @author Martin Štulc, Jan Šváb
 *
 */
@ManagedBean(name = "document")
@ViewScoped
public class DocumentFormBean implements Serializable {
  /** srial version id */
  private static final long serialVersionUID = 1L;

  /** beana pro práci s dokumentem */
  @EJB
  private DocumentService documentServiceBean;

  /** beana pro validaci dokumentu */
  @EJB
  private DocumentValidateService documentValidateServicebean;

  /** beana pro práci s identitami */
  @EJB
  private IdentityService identityservicebean;

  /** beana pro práci s pobyty */
  @EJB
  private StayService stayservicebean;

  /** datum přijetí */
  private Date dateofreceipt;

  /** datum prodloužení */
  private Date dateofrenewal;

  /** datum zrušení */
  private Date dateofcancel;

  /** id typu dokumentu */
  private Integer idcodedocumenttype;

  /** id identity, která dokument vlastní */
  private Integer ididentity;

  /** id persony, která dokument vlastní */
  private Integer idperson;

  /** id státu, který dokument vydal */
  private Integer idstateissued;

  /** id pobytu */
  private Integer idtdustay;

  /** poznámka */
  private String note;

  /** číslo dokladu */
  private String number;

  /** datum platnosti od */
  private Date validfrom;

  /** datum platnosti do */
  private Date validto;

  /** list identit pro danou osobu */
  private List<Identity> identities;

  /** list pobytů pro danou osobu */
  private List<Tdustay> stays;

  /** inicializace listů */
  public void init() {
    identities = listIdentitiesOfPerson();
    stays = listStays();
  }

  /**
   * Vytvoří dokument.
   *
   * @return url k detailu dokumentu
   */
  public String createDocument() {
    if (!testBeans())
      return null;

    Tdudocument document = generateDocument();

    String[] validate = documentValidateServicebean.validate(document);
    if (validate == null) {
      document = documentServiceBean.create(document);
    } else {
      for (int i = 0; i < validate.length; i++) {
        FacesMessage message = new FacesMessage(
            "Chyba při validaci dokumentu! (" + validate[i] + ")");
        FacesContext.getCurrentInstance().addMessage(null, message);
      }
      return null;
    }

    return Constants.PAGE_VIEW_DETAIL
        + "?faces-redirect=true&amp;includeViewParams=true";
  }

  /**
   * Ostestuje dostupnost bean.
   *
   * @return true pokud jse vše OK
   */
  private boolean testBeans() {
    if (documentValidateServicebean == null) {
      FacesMessage message = new FacesMessage(
          "documentValidateServicebean null!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return false;
    }

    if (documentServiceBean == null) {
      FacesMessage message = new FacesMessage("documentServiceBean null!");
      FacesContext.getCurrentInstance().addMessage(null, message);
      return false;
    }

    return true;
  }

  /**
   * Vytvoří entitu dokumentu ze zadaných hodnot.
   *
   * @return entita dokumentu
   */
  private Tdudocument generateDocument() {
    Tdudocument document = new Tdudocument();
    document.setDateofreceipt(dateofreceipt);
    document.setDateofrenewal(dateofrenewal);
    document.setDateofcancel(dateofcancel);
    document.setIdcodedocumenttype(idcodedocumenttype);
    document.setIdidentity(ididentity);
    document.setIdperson(idperson);
    document.setIdstateissued(idstateissued);
    document.setIdtdustay(idtdustay);
    document.setNote(note);
    document.setNumber(number);
    document.setValidfrom(validfrom);
    document.setValidto(validto);
    return document;
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
    dateofreceipt = null;
    dateofrenewal = null;
    dateofcancel = null;
    idcodedocumenttype = null;
    ididentity = null;
    idstateissued = null;
    idtdustay = null;
    note = null;
    number = null;
    validfrom = null;
  }

  /**
   * Vrátí list identit persony, jejíž dokument je.
   *
   * @return list identit
   */
  public List<Identity> listIdentitiesOfPerson() {
    if (idperson == null)
      return new ArrayList<Identity>();

    return identityservicebean.findIdentitiesForPerson(idperson);
  }

  /**
   * Vrátí list pobytů persony, jejíž dokument je.
   *
   * @return list pobytů
   */
  public List<Tdustay> listStays() {
    if (idperson == null)
      return new ArrayList<Tdustay>();

    return stayservicebean.listStaysForPerson(idperson);
  }

  /**
   * Vrátí řetězec platnosti dokumentu
   *
   * @return Řetezec platnosti dokumentu.
   */
  public String getValidDates() {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    return (df.format(this.validfrom) + " - " + df.format(this.validto));
  }

  /**
   * @return datup přijetí
   */
  public Date getDateofreceipt() {
    return dateofreceipt;
  }

  /**
   * Nastaví datum přijetí.
   *
   * @param dateofreceipt
   *          datum přijetí
   */
  public void setDateofreceipt(Date dateofreceipt) {
    this.dateofreceipt = dateofreceipt;
  }

  /**
   * @return datum prodloužení
   */
  public Date getDateofrenewal() {
    return dateofrenewal;
  }

  /**
   * Nastaví datum prodloužení
   *
   * @param dateofrenewal
   *          datum prodloužení
   */
  public void setDateofrenewal(Date dateofrenewal) {
    this.dateofrenewal = dateofrenewal;
  }

  /**
   * @return id typu dokumentu
   */
  public Integer getIdcodedocumenttype() {
    return idcodedocumenttype;
  }

  /**
   * Nastaví id typu dokumentu.
   *
   * @param idcodedocumenttype
   *          id typu dokumentu
   */
  public void setIdcodedocumenttype(Integer idcodedocumenttype) {
    this.idcodedocumenttype = idcodedocumenttype;
  }

  /**
   * @return id identity
   */
  public Integer getIdidentity() {
    return ididentity;
  }

  /**
   * Nastaví id identity.
   *
   * @param ididentity
   *          id identity
   */
  public void setIdidentity(Integer ididentity) {
    this.ididentity = ididentity;
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
   * @return id státu, který dokument vydal
   */
  public Integer getIdstateissued() {
    return idstateissued;
  }

  /**
   * Nastaví id státu, který dokument vydal.
   *
   * @param idstateissued
   *          id státu
   */
  public void setIdstateissued(Integer idstateissued) {
    this.idstateissued = idstateissued;
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
   *          id pobytu
   */
  public void setIdtdustay(Integer idtdustay) {
    this.idtdustay = idtdustay;
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
   * @return číslo dokladu
   */
  public String getNumber() {
    return number;
  }

  /**
   * Nastaví číslo dokladu.
   *
   * @param number
   *          číslo dokladu
   */
  public void setNumber(String number) {
    this.number = number;
  }

  /**
   * @return datum platnosti od
   */
  public Date getValidfrom() {
    return validfrom;
  }

  /**
   * NAstaví datum platnosti od.
   *
   * @param validfrom
   *          datum platnosti od
   */
  public void setValidfrom(Date validfrom) {
    this.validfrom = validfrom;
  }

  /**
   * @return datum platnosti do
   */
  public Date getValidto() {
    return validto;
  }

  /**
   * Nastaví datum platnosti do.
   *
   * @param validto
   *          platnosti do
   */
  public void setValidto(Date validto) {
    this.validto = validto;
  }

  /**
   * @return datum zrušení
   */
  public Date getDateofcancel() {
    return dateofcancel;
  }

  /**
   * Nastaví datum zrušení.
   *
   * @param dateofcancel
   *          datum zrušení
   */
  public void setDateofcancel(Date dateofcancel) {
    this.dateofcancel = dateofcancel;
  }

  /**
   * Vrátí list identit persony, která dokument vlastní.
   *
   * @return list identit
   */
  public List<Identity> getIdentities() {
    return identities;
  }

  /**
   * Vrátí list pobytů persony, která dokument vlastní.
   *
   * @return list pobytů persony
   */
  public List<Tdustay> getStays() {
    return stays;
  }
}
