package cz.i.cis.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
 *
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

  /** aktuálí vybraná persona */
  private Tduperson selectedPerson;

  /** aktuální identita persony */
  private Identity actualPersonIdentity;

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
      // TODO hlaska
      return;
    }

    Integer idIdentity = selectedPerson.getIdidentityActual();
    actualPersonIdentity = identityservicebean.findIdentityById(idIdentity);
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
      identities = identityservicebean.findIdentitiesForPerson(selectedPerson
          .getId());
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
      documents = documentservicebean.findDocumentsForPerson(selectedPerson
          .getId());
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
      stayplaces = stayplaceservicebean.findStayPlacesForPerson(selectedPerson
          .getId());
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

  public String outcomeNewIdentity() {
    return Constants.PAGE_CREATE_IDENTITY + "?personid=" + idperson
        + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }

  public String outcomeNewDocument() {
    return Constants.PAGE_CREATE_DOCUMENT + "?personid=" + idperson
        + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }

  public String outcomeNewStay() {
    return Constants.PAGE_CREATE_STAY + "?personid=" + idperson
        + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }

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

  public String outcomeEditIdentity(Integer id) {
    return Constants.PAGE_UPDATE_IDENTITY + "?identityid=" + id
        + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }

  public String outcomeEditPerson(Integer id) {
    return Constants.PAGE_UPDATE_PERSON + "?documentid=" + id
        + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }
}
