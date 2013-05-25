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
import cz.i.cis.db.person.StayPlaceService;
import cz.i.cis.db.person.StayService;
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

    public void changeActualIdentity(Integer id)
    {
      Identity requiredIdentity = identityservicebean.findIdentityById(id);
      selectedPerson.setIdidentityActual(id);

      personservicebean.update(selectedPerson);

      actualPersonIdentity = requiredIdentity;
    }

    public List<Identity> listIdentities() {

        if (selectedPerson == null)
            return new ArrayList<Identity>();

        return identityservicebean.findIdentitiesForPerson(selectedPerson
                .getId());
    }

    public List<Tdustay> listStays() {
        if (selectedPerson == null)
            return new ArrayList<Tdustay>();

        return stayservicebean.listStaysForPerson(selectedPerson.getId());
    }

    public List<Tdudocument> listDocuments()
    {
      if (selectedPerson == null)
        return new ArrayList<Tdudocument>();

      return documentservicebean.findDocumentsForPerson(selectedPerson.getId());
    }

    public List<Tdustayplace> listStayplaces()
    {
      if (selectedPerson == null)
        return new ArrayList<Tdustayplace>();

      return stayplaceservicebean.findStayPlacesForPerson(selectedPerson.getId());
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

    public String outcomeNewIdentity()
    {
        return Constants.PAGE_CREATE_IDENTITY;
    }

    public String outcomeNewDocument()
    {
        return Constants.PAGE_CREATE_DOCUMENT;
    }

    public String outcomeNewStay()
    {
        return Constants.PAGE_CREATE_STAY;
    }

    public String outcomeNewStayplace()
    {
        return Constants.PAGE_CREATE_STAYPLACE;
    }
}
