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

@ManagedBean(name = "personview")
@ViewScoped
public class PersonDetailViewBean implements Serializable {

  private static final long serialVersionUID = 1L;

  @EJB
  private PersonService personservicebean;

  @EJB
  private IdentityService identityservicebean;

  @EJB
  private StayService stayservicebean;

  @EJB
  private DocumentService documentservicebean;

  @EJB
  private StayPlaceService stayplaceservicebean;

  private Tduperson selectedPerson;
  private Identity actualPersonIdentity;

  private Integer idperson;

  private List<Tdudocument> documents = null;

  private Tdudocument selectedDoc = null;

  private List<Identity> identities = null;

  private Identity selectedIdentity = null;

  private List<Tdustay> stays = null;

  private List<Tdustayplace> stayplaces = null;

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


  public void changeActualIdentity(Integer id) {
    Identity requiredIdentity = identityservicebean.findIdentityById(id);
    selectedPerson.setIdidentityActual(id);

    personservicebean.update(selectedPerson);

    actualPersonIdentity = requiredIdentity;
  }


  public List<Identity> listIdentities() {
    if (selectedPerson != null)
      identities = identityservicebean.findIdentitiesForPerson(selectedPerson.getId());
    else
      identities = new ArrayList<Identity>();

    return identities;
  }


  public List<Tdustay> listStays() {
    if (selectedPerson != null) stays = stayservicebean.listStaysForPerson(selectedPerson.getId());
    else stays = new ArrayList<Tdustay>();

    return stays;
  }


  public List<Tdudocument> listDocuments() {
    if (selectedPerson != null)
      documents = documentservicebean.findDocumentsForPerson(selectedPerson.getId());
    else
      documents = new ArrayList<Tdudocument>();

    return documents;
  }


  public List<Tdustayplace> listStayplaces() {
    if (selectedPerson != null) stayplaces = stayplaceservicebean.findStayPlacesForPerson(selectedPerson.getId());
    else stayplaces = new ArrayList<Tdustayplace>();

    return stayplaces;
  }


  public void showDocument(Integer id) {
    selectedDoc = null;
    for (Tdudocument d : documents) {
      if (d.getId() == id) {
        selectedDoc = d;
        break;
      }
    }
  }


  public void showIdentity(Integer id) {
    selectedIdentity = null;
    for (Identity i : identities) {
      if (i.getId() == id) {
        selectedIdentity = i;
        break;
      }
    }
  }


  public void deleteStay(Integer id)
  {
    for (Tdustay s : stays) {
      if (s.getId() == id) {
        stayservicebean.delete(s);
        break;
      }
    }
  }

  public void deleteStayplace(Integer id)
  {
    for (Tdustayplace sp : stayplaces) {
      if (sp.getId() == id) {
        stayplaceservicebean.delete(sp);
        break;
      }
    }
  }

  public void deleteDocument(Integer id)
  {
    for (Tdudocument d : documents) {
      if (d.getId() == id) {
        documentservicebean.delete(d);
        break;
      }
    }

    if(selectedDoc != null && selectedDoc.getId() == id) selectedDoc = null;
  }


  public void cleanDetailViews()
  {
    selectedDoc = null;
    documents = new ArrayList<Tdudocument>();

    selectedIdentity = null;
    identities = new ArrayList<Identity>();

    stays = new ArrayList<Tdustay>();

    stayplaces = new ArrayList<Tdustayplace>();
  }

  public Tduperson getSelectedPerson() {
    return selectedPerson;
  }


  public Identity getActualPersonIdentity() {
    return actualPersonIdentity;
  }


  public Integer getIdperson() {
    return idperson;
  }


  public void setIdperson(Integer idperson) {
    this.idperson = idperson;
  }


  public String outcomeNewIdentity() {
    return Constants.PAGE_CREATE_IDENTITY + "?personid=" + idperson + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }


  public String outcomeNewDocument() {
    return Constants.PAGE_CREATE_DOCUMENT + "?personid=" + idperson + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }


  public String outcomeNewStay() {
    return Constants.PAGE_CREATE_STAY + "?personid=" + idperson + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }


  public String outcomeNewStayplace() {
    return Constants.PAGE_CREATE_STAYPLACE + "?personid=" + idperson + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }


  public Tdudocument getSelectedDoc() {
    return this.selectedDoc;
  }


  public Identity getSelectedIdentity() {
    return selectedIdentity;
  }

  public String outcomeEditIdentity(Integer id)
  {
    return Constants.PAGE_UPDATE_IDENTITY + "?identityid=" + id + "&amp;faces-redirect=true&amp;includeViewParams=true";
  }
}
