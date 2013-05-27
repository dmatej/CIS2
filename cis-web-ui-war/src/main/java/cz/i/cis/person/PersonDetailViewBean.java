package cz.i.cis.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cz.i.cis.db.code.CodeService;
import cz.i.cis.db.documents.DocumentService;
import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.entities.Tdudocument;
import cz.i.cis.db.entities.Tduperson;
import cz.i.cis.db.entities.Tdustay;
import cz.i.cis.db.entities.Tdustayplace;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.person.PersonService;
import cz.i.cis.db.places.StayPlaceService;
import cz.i.cis.db.places.StayService;
import cz.i.cis.other.Constants;

/**
 * Beana, zobrazující detail osoby, umožňující vybýrat aktuální pobyty, místa
 * pobytu, identity i dokumenty a zobrazovat jejich detaily.
 *
 * @author Jan Šváb
 */
@ManagedBean(name = "personview")
@ViewScoped
public class PersonDetailViewBean implements Serializable {

  private static final long serialVersionUID = 1L;

  /** beana pro práci s personou */
  @EJB
  private PersonService personservicebean;

  /** beana pro práci s identitou */
  @EJB
  private IdentityService identityservicebean;

  /** beana pro práci s pobytem */
  @EJB
  private StayService stayservicebean;

  /** beana pro práci s dokumentem */
  @EJB
  private DocumentService documentservicebean;

  /** beana pro práci s místem pobytu */
  @EJB
  private StayPlaceService stayplaceservicebean;

  @EJB
  private CodeService codeservicebean;

  private Tduperson selectedPerson;

  /** aktuální identita persony */
  private Identity actualPersonIdentity;
  private Tdustay actualStay;
  private Tdustayplace actualStayPlace;

  /** id persony */
  private Integer idperson;

  /** list dokumentů persony */
  private List<Tdudocument> documents = null;

  /** vybraný dokument persony */
  private Tdudocument selectedDoc = null;

  /** list identit dané persony */
  private List<Identity> identities = null;

  /** vybraná identita persony */
  private Identity selectedIdentity = null;

  /** list pobytů persony */
  private List<Tdustay> stays = null;

  /** list míst pobytu persony */
  private List<Tdustayplace> stayplaces = null;

  /**
   * Pokud vyvolan pozadavek na zmenu dat osoby, obsahuje data formulare pro zmenu udaju.
   */
  private PersonEditData personEditData = null;


  /**
   * Načte personu podle nastaveného idperson.
   */
  public void loadPerson() {
    selectedPerson = null;
    actualPersonIdentity = null;

    if (idperson == null) {
      return;
    }

    selectedPerson = personservicebean.findPersonById(idperson);
    if (selectedPerson == null) {
      return;
    }

    Integer idIdentity = selectedPerson.getIdidentityActual();
    actualPersonIdentity = identityservicebean.findIdentityById(idIdentity);

    if (selectedPerson.getIdstayActual() != null)
      actualStay = stayservicebean.findStayById(selectedPerson.getIdstayActual());

    if (selectedPerson.getIdstayplaceActual() != null)
      actualStayPlace = stayplaceservicebean.findStayPlaceById(selectedPerson.getIdstayplaceActual());
  }


  /**
   * Změní aktuální identitu persony.
   *
   * @param id
   *          id nové aktuální identity
   */
  public void changeActualIdentity(Integer id) {
    Identity requiredIdentity = identityservicebean.findIdentityById(id);
    selectedPerson.setIdidentityActual(id);

    personservicebean.update(selectedPerson);

    actualPersonIdentity = requiredIdentity;
  }


  /**
   * Vrátí list identit persony.
   *
   * @return list identit persony
   */
  public List<Identity> listIdentities() {
    if (selectedPerson != null)
      identities = identityservicebean.findIdentitiesForPerson(selectedPerson.getId());
    else
      identities = new ArrayList<Identity>();

    return identities;
  }


  /**
   * Vrátí list pobytů persony.
   *
   * @return list pobytů persony
   */
  public List<Tdustay> listStays() {
    if (selectedPerson != null)
      stays = stayservicebean.listStaysForPerson(selectedPerson.getId());
    else
      stays = new ArrayList<Tdustay>();

    return stays;
  }


  /**
   * Vrátí list dokumentů persony.
   *
   * @return list dokumentů persony
   */
  public List<Tdudocument> listDocuments() {
    if (selectedPerson != null)
      documents = documentservicebean.findDocumentsForPerson(selectedPerson.getId());
    else
      documents = new ArrayList<Tdudocument>();

    return documents;
  }


  /**
   * Vrátí list míst pobytu persony.
   *
   * @return list míst pobytu
   */
  public List<Tdustayplace> listStayplaces() {
    if (selectedPerson != null)
      stayplaces = stayplaceservicebean.findStayPlacesForPerson(selectedPerson.getId());
    else
      stayplaces = new ArrayList<Tdustayplace>();

    return stayplaces;
  }


  /**
   * Nastaví vybraný dokument.
   *
   * @param id
   *          id nového vybraného dokumentu
   */
  public void showDocument(Integer id) {
    personEditData = null;
    selectedDoc = null;

    for (Tdudocument d : documents) {
      if (d.getId() == id) {
        selectedDoc = d;
        break;
      }
    }
  }


  /**
   * Nastaví aktuální vybranou identitu.
   *
   * @param id
   *          id nové vybrané identity
   */
  public void showIdentity(Integer id) {
    personEditData = null;
    selectedIdentity = null;

    for (Identity i : identities) {
      if (i.getId() == id) {
        selectedIdentity = i;
        break;
      }
    }
  }


  /**
   * Smaže pobyt.
   *
   * @param id
   *          id mazaného pobytu
   */
  public void deleteStay(Integer id) {
    for (Tdustay s : stays) {
      if (s.getId() == id) {
        stayservicebean.delete(s);
        break;
      }
    }
  }


  /**
   * Smaže místo pobytu.
   *
   * @param id
   *          id mazaného místa pobytu
   */
  public void deleteStayplace(Integer id) {
    for (Tdustayplace sp : stayplaces) {
      if (sp.getId() == id) {
        stayplaceservicebean.delete(sp);
        break;
      }
    }
  }


  /**
   * Smaže dokument.
   *
   * @param id
   *          id mazaného dokumentu.
   */
  public void deleteDocument(Integer id) {
    for (Tdudocument d : documents) {
      if (d.getId() == id) {
        documentservicebean.delete(d);
        break;
      }
    }

    if (selectedDoc != null && selectedDoc.getId() == id)
      selectedDoc = null;
  }


  /**
   * Smaže detaily zobrazení persony.
   */
  public void cleanDetailViews() {
    selectedDoc = null;
    documents = new ArrayList<Tdudocument>();

    selectedIdentity = null;
    identities = new ArrayList<Identity>();

    stays = new ArrayList<Tdustay>();

    stayplaces = new ArrayList<Tdustayplace>();
  }


  /**
   * Reakce na pozadavek na editaci osoby. Pripravi data pro editacni formular.
   */
  public void reqEditPersonData() {
    selectedDoc = null;
    selectedIdentity = null;

    if (selectedPerson == null)
      return;

    personEditData = new PersonEditData();
    personEditData.setDeathdate(selectedPerson.getDeathdate());
    personEditData.setDeathplace(selectedPerson.getDeathplace());
    personEditData.setDegreeprefix(selectedPerson.getDegreeprefix());
    personEditData.setDegreesuffix(selectedPerson.getDegreesuffix());
    personEditData.setNote(selectedPerson.getNote());
    personEditData.setIddeathplace(selectedPerson.getIddeathplace());
    personEditData.setIddeathstate(selectedPerson.getIddeathstate());
    personEditData.setIdstayActual(selectedPerson.getIdstayActual());
    personEditData.setIdstayplaceActual(selectedPerson.getIdstayplaceActual());

    personEditData.setListStays(stayservicebean.listStaysForPerson(selectedPerson.getId()));
    personEditData.setListStayPlaces(stayplaceservicebean.findStayPlacesForPerson(selectedPerson.getId()));
  }


  /**
   * Stornuje pozadavek na editace dat osoby.
   */
  public void stornoReqEditPersonData() {
    personEditData = null;
  }


  /**
   * Provede editaci osoby.
   */
  public void editPersonData() {
    selectedPerson.setDeathdate(personEditData.getDeathdate());
    selectedPerson.setDeathplace(personEditData.getDeathplace());
    selectedPerson.setDegreeprefix(personEditData.getDegreeprefix());
    selectedPerson.setDegreesuffix(personEditData.getDegreesuffix());
    selectedPerson.setNote(personEditData.getNote());
    selectedPerson.setIddeathplace(personEditData.getIddeathplace());
    selectedPerson.setIddeathstate(personEditData.getIddeathstate());
    selectedPerson.setIdstayActual(personEditData.getIdstayActual());
    selectedPerson.setIdstayplaceActual(personEditData.getIdstayplaceActual());

    personservicebean.update(selectedPerson);

    personEditData = null;
  }


  /**
   * @return vybraná persona.
   */
  public Tduperson getSelectedPerson() {
    return selectedPerson;
  }


  /**
   * @return aktuální identita vybrané persony
   */
  public Identity getActualPersonIdentity() {
    return actualPersonIdentity;
  }


  /**
   * @return id vybrané persony
   */
  public Integer getIdperson() {
    return idperson;
  }


  /**
   * Nastaví id vybrané persony.
   *
   * @param idperson
   *          id vybrané persony
   */
  public void setIdperson(Integer idperson) {
    this.idperson = idperson;
  }


  /**
   * Vraci adresu formulare pro vytvoreni nove identity.
   *
   * @return URL formulare pro vytvoreni nove identity
   */
  public String outcomeNewIdentity() {
    return Constants.PAGE_CREATE_IDENTITY + "?personid=" + idperson
        + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }


  /**
   * Vraci adresu formulare pro vytvoreni noveho dokumentu.
   *
   * @return URL formulare pro vytvoreni noveho dokumentu
   */
  public String outcomeNewDocument() {
    return Constants.PAGE_CREATE_DOCUMENT + "?personid=" + idperson
        + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }


  /**
   * Vraci adresu formulare pro vytvoreni noveho pobytu.
   *
   * @return URL formulare pro vytvoreni nove identity
   */
  public String outcomeNewStay() {
    return Constants.PAGE_CREATE_STAY + "?personid=" + idperson + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }


  /**
   * Vraci adresu formulare pro vytvoreni noveho mista pobytu.
   *
   * @return URL formulare pro vytvoreni nove identity
   */
  public String outcomeNewStayplace() {
    return Constants.PAGE_CREATE_STAYPLACE + "?personid=" + idperson
        + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }


  /**
   * @return vybraný dokument
   */
  public Tdudocument getSelectedDoc() {
    return this.selectedDoc;
  }


  /**
   * @return vybraná identita
   */
  public Identity getSelectedIdentity() {
    return selectedIdentity;
  }


  /**
   * Vraci adresu formulare pro editaci identity.
   *
   * @param id ID identity, ktera se ma editovat
   * @return URL formulare pro editaci identity
   */
  public String outcomeEditIdentity(Integer id) {
    return Constants.PAGE_UPDATE_IDENTITY + "?identityid=" + id + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }


  /**
   * @return Reference na objekt dat editacniho formulare osoby
   */
  public PersonEditData getPersonEditData() {
    return personEditData;
  }


  /**
   * @return Reference na objekt s aktualnim pobytem
   */
  public Tdustay getActualStay() {
    return actualStay;
  }


  /**
   * @return Reference na objekt s aktualnim mistem pobytu
   */
  public Tdustayplace getActualStayPlace() {
    return actualStayPlace;
  }
}
