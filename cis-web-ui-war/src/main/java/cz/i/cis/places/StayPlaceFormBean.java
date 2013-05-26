package cz.i.cis.places;

import java.io.Serializable;
import java.sql.Timestamp;
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

import cz.i.cis.db.entities.Tduperson;
import cz.i.cis.db.entities.Tdustay;
import cz.i.cis.db.entities.Tdustayplace;
import cz.i.cis.db.person.PersonService;
import cz.i.cis.db.places.StayPlaceService;
import cz.i.cis.db.places.StayService;
import cz.i.cis.db.validate.StayPlaceValidateService;
import cz.i.cis.other.Constants;

@ManagedBean(name = "stayplace")
@ViewScoped
public class StayPlaceFormBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private StayPlaceService stayPlaceServiceBean;

    @EJB
    private StayService stayServiceBean;

    @EJB
    private PersonService  personServiceBean;

    @EJB
    private StayPlaceValidateService stayPlaceValidateServicebean;

    private Date datefrom;

    private Date dateto;

    private Timestamp ddate;

    private String address;

    private Integer idperson;

    private Integer idtdustay;

    private String note;

    private Boolean asActual = false;

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

            if(asActual)
            {
                Tduperson p = personServiceBean.findPersonById(idperson);
                p.setIdstayplaceActual(stayPlace.getId());
                p.setIdstayActual(stayPlace.getIdtdustay());
                personServiceBean.update(p);
            }

        } else {
            for (int i = 0; i < validate.length; i++) {
                FacesMessage message = new FacesMessage(
                        "Chyba při validaci pobytu! (" + validate[i] + ")");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            return null;
        }

        return Constants.PAGE_VIEW_DETAIL + "?faces-redirect=true&amp;includeViewParams=true";
    }

    public List<Tdustayplace> getStayPlacesForPerson(Integer idPerson) {
        if (!testBeans())
            return null;

        return stayPlaceServiceBean.findStayPlacesForPerson(idPerson);
    }

    public List<Tdustayplace> getStayPlacesForStay(Integer idStay) {
        if (!testBeans())
            return null;

        return stayPlaceServiceBean.findStayPlacesForStay(idStay);
    }

    public List<Tdustay> listStays()
    {
      if(idperson == null) return new ArrayList<Tdustay>();

      return stayServiceBean.listStaysForPerson(idperson);
    }

    public void clearForm()
    {
      Map<String,String> params =  FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
      try
      {
        idperson = Integer.parseInt(params.get("personid"));
      }
      catch(Exception e) {idperson = null; }

      //for sure (thanks RequestScope are data deleted)

      datefrom = null;
      dateto = null;
      address = null;
      idtdustay = null;
      note = null;
    }

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

    public Date getDatefrom() {
      return datefrom;
    }

    public void setDatefrom(Date datefrom) {
      this.datefrom = datefrom;
    }

    public Date getDateto() {
      return dateto;
    }

    public void setDateto(Date dateto) {
      this.dateto = dateto;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public String getNote() {
      return note;
    }

    public void setNote(String note) {
      this.note = note;
    }

    public Integer getIdperson() {
      return idperson;
    }

    public void setIdperson(Integer idperson) {
      this.idperson = idperson;
    }

    public Boolean getAsActual() {
      return asActual;
    }

    public void setAsActual(Boolean asActual) {
      this.asActual = asActual;
    }

    public Integer getIdtdustay() {
      return idtdustay;
    }

    public void setIdtdustay(Integer idtdustay) {
      this.idtdustay = idtdustay;
    }
}