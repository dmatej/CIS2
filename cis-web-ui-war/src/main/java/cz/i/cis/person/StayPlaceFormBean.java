package cz.i.cis.person;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cz.i.cis.db.entities.Tdustayplace;
import cz.i.cis.db.person.StayPlaceService;
import cz.i.cis.db.validate.StayPlaceValidateService;

@Named("stayplace")
public class StayPlaceFormBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private StayPlaceService stayPlaceServiceBean;

    @EJB
    private StayPlaceValidateService stayPlaceValidateServicebean;

    private Date datefrom;

    private Date dateto;

    private Timestamp ddate;

    private String address;

    private Integer idperson;

    private Integer idtdustay;

    private String note;

    public Tdustayplace createStayPlace() {
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

            FacesMessage message = new FacesMessage("Pobyt vytvořen!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            for (int i = 0; i < validate.length; i++) {
                FacesMessage message = new FacesMessage(
                        "Chyba při validaci pobytu! (" + validate[i] + ")");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            return null;
        }
        return stayPlace;
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
}