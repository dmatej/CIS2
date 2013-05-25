package cz.i.cis.person;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.entities.Tdustay;
import cz.i.cis.db.person.StayService;
import cz.i.cis.db.validate.StayValidateService;
import cz.i.cis.other.Constants;

@Named("stay")
@RequestScoped
public class StayFormBean implements Serializable {

  private static final long serialVersionUID = 1L;

  @EJB
  private StayService stayServiceBean;

  @EJB
  private StayValidateService stayValidateServicebean;

  private Integer id;

  private Date grantedfrom;

  private Date grantedto;

  private Integer idperson;

  private String note;

  private String refnumber;

  private Integer idpobytucel;

  public String createStay() {
    if (!testBeans())
      return null;

    Tdustay stay = generateEntity();

    String[] validate = stayValidateServicebean.validate(stay);
    if (validate == null) {
      stay = stayServiceBean.create(stay);

      FacesMessage message = new FacesMessage("Pobyt vytvořen!");
      FacesContext.getCurrentInstance().addMessage(null, message);
    } else {
      for (int i = 0; i < validate.length; i++) {
        FacesMessage message = new FacesMessage("Chyba při validaci pobytu! ("
            + validate[i] + ")");
        FacesContext.getCurrentInstance().addMessage(null, message);
      }
      return null;
    }

    return Constants.PAGE_VIEW_DETAIL + "?faces-redirect=true&amp;includeViewParams=true";
  }

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

  public void clearForm()
  {
    Map<String,String> params =  FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    try
    {
      idperson = Integer.parseInt(params.get("personid"));
    }
    catch(Exception e) { idperson = null; }

  //for sure (thanks RequestScope are data deleted)
    grantedfrom = null;
    grantedto = null;
    note = null;
    refnumber = null;
    idpobytucel = null;
  }

  public List<Tdustay> listStaysForPerson(Integer idPerson) {
    if (!testBeans())
      return null;

    return stayServiceBean.listStaysForPerson(idPerson);
  }

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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getGrantedfrom() {
    return grantedfrom;
  }

  public void setGrantedfrom(Date grantedfrom) {
    this.grantedfrom = grantedfrom;
  }

  public Date getGrantedto() {
    return grantedto;
  }

  public void setGrantedto(Date grantedto) {
    this.grantedto = grantedto;
  }

  public Integer getIdperson() {
    return idperson;
  }

  public void setIdperson(Integer idperson) {
    this.idperson = idperson;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getRefnumber() {
    return refnumber;
  }

  public void setRefnumber(String refnumber) {
    this.refnumber = refnumber;
  }

  public Integer getIdpobytucel() {
    return idpobytucel;
  }

  public void setIdpobytucel(Integer idpobytucel) {
    this.idpobytucel = idpobytucel;
  }
}
