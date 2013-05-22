package cz.i.cis.person;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.entities.Tdustay;
import cz.i.cis.db.person.StayService;
import cz.i.cis.db.validate.StayValidateService;

@Named("stay")
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

  public Tdustay createStay() {
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
    return stay;
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

  public List<Tdustay> getStaysForPerson(Integer idPerson) {
    if (!testBeans())
      return null;

    return stayServiceBean.getStaysForPerson(idPerson);
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
