package cz.i.cis.documents;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.documents.DocumentService;
import cz.i.cis.db.entities.Identity;
import cz.i.cis.db.entities.Tdudocument;
import cz.i.cis.db.entities.Tdustay;
import cz.i.cis.db.person.IdentityService;
import cz.i.cis.db.places.StayService;
import cz.i.cis.db.validate.DocumentValidateService;
import cz.i.cis.other.Constants;

@ManagedBean(name = "document")
@ViewScoped
public class DocumentFormBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private DocumentService documentServiceBean;

    @EJB
    private DocumentValidateService documentValidateServicebean;

    @EJB
    private IdentityService identityservicebean;

    @EJB
    private StayService stayservicebean;

    private Date dateofreceipt;

    private Date dateofrenewal;

    private Date dateofcancel;

    private Integer idcodedocumenttype;

    private Integer ididentity;

    private Integer idperson;

    private Integer idstateissued;

    private Integer idtdustay;

    private String note;

    private String number;

    private Date validfrom;

    private Date validto;

    private List<Identity> identities;

    private List<Tdustay> stays;

    public void init()
    {
      identities = listIdentitiesOfPerson();
      stays = listStays();
    }

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

        return Constants.PAGE_VIEW_DETAIL + "?faces-redirect=true&amp;includeViewParams=true";
    }

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

    public void clearForm()
    {
      Map<String,String> params =  FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
      try
      {
        idperson = Integer.parseInt(params.get("personid"));
      }
      catch(Exception e) { idperson = null; }

    //for sure (thanks RequestScope are data deleted)
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

    public List<Identity> listIdentitiesOfPerson()
    {
      if(idperson == null) return new ArrayList<Identity>();

      return identityservicebean.findIdentitiesForPerson(idperson);
    }

    public List<Tdustay> listStays()
    {
      if(idperson == null) return new ArrayList<Tdustay>();

      return stayservicebean.listStaysForPerson(idperson);
    }

    public String getValidDates() {
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
      return (df.format(this.validfrom) + " - " + df.format(this.validto));
    }

    public Date getDateofreceipt() {
        return dateofreceipt;
    }

    public void setDateofreceipt(Date dateofreceipt) {
        this.dateofreceipt = dateofreceipt;
    }

    public Date getDateofrenewal() {
        return dateofrenewal;
    }

    public void setDateofrenewal(Date dateofrenewal) {
        this.dateofrenewal = dateofrenewal;
    }

    public Integer getIdcodedocumenttype() {
        return idcodedocumenttype;
    }

    public void setIdcodedocumenttype(Integer idcodedocumenttype) {
        this.idcodedocumenttype = idcodedocumenttype;
    }

    public Integer getIdidentity() {
        return ididentity;
    }

    public void setIdidentity(Integer ididentity) {
        this.ididentity = ididentity;
    }

    public Integer getIdperson() {
        return idperson;
    }

    public void setIdperson(Integer idperson) {
        this.idperson = idperson;
    }

    public Integer getIdstateissued() {
        return idstateissued;
    }

    public void setIdstateissued(Integer idstateissued) {
        this.idstateissued = idstateissued;
    }

    public Integer getIdtdustay() {
        return idtdustay;
    }

    public void setIdtdustay(Integer idtdustay) {
        this.idtdustay = idtdustay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public Date getValidto() {
        return validto;
    }

    public void setValidto(Date validto) {
        this.validto = validto;
    }

    public Date getDateofcancel() {
      return dateofcancel;
    }

    public void setDateofcancel(Date dateofcancel) {
      this.dateofcancel = dateofcancel;
    }


    public List<Identity> getIdentities() {
      return identities;
    }


    public List<Tdustay> getStays() {
      return stays;
    }
}
