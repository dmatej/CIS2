package cz.i.cis.places;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import cz.i.cis.db.entities.CodeState;
import cz.i.cis.db.places.StateService;

@ManagedBean(name="state")
@ViewScoped
public class StateFormBean {
    private String name;

    private String nameCZ;

    private String nameEN;

    private String nameFull;

    private String nameNativ;

    private String code;

    private Integer idstate;

    private CodeState selectedState = null;

    @EJB
    private StateService stateServiceBean;


    public List<CodeState> getListStates()
    {
        return stateServiceBean.listStates();
    }

    public void submit()
    {
        if(nameCZ.trim().equals("")) nameCZ = name;
        if(nameEN.trim().equals("")) nameEN = name;
        if(nameFull.trim().equals("")) nameFull = name;
        if(nameNativ.trim().equals("")) nameNativ = name;

        if(!validData())
        {
            //TODO osetrit
            return;
        }

        stateServiceBean.create(name, nameCZ, nameEN, nameFull, nameNativ, code, idstate);
    }

    public String edit()
    {
        return "states-edit";
    }

    public void loadState(int id)
    {
        selectedState = stateServiceBean.loadState(id);
    }

    public boolean validData()
    {
        boolean bCreate = true;

        if(name.trim().equalsIgnoreCase(""))
        {
            FacesMessage message = new FacesMessage("Nebyl zadán hlavní název státu!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            bCreate = false;
        }

        if(code.trim().equalsIgnoreCase(""))
        {
            FacesMessage message = new FacesMessage("Nebyl zadán kód státu!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            bCreate = false;
        }

        if(!code.trim().equalsIgnoreCase("") && stateServiceBean.exists(code, idstate))
        {
            FacesMessage message = new FacesMessage("Stát s uvedeným kódem nebo ID již existuje!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            bCreate = false;
        }

        return bCreate;
    }

    public String getName() {
        return name;
    }

    public String getNameCZ() {
        return nameCZ;
    }

    public String getNameEN() {
        return nameEN;
    }

    public String getNameFull() {
        return nameFull;
    }

    public String getNameNativ() {
        return nameNativ;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameCZ(String nameCZ) {
        this.nameCZ = nameCZ;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public void setNameNativ(String nameNativ) {
        this.nameNativ = nameNativ;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getIdstate() {
        return idstate;
    }

    public void setIdstate(Integer idstate) {
        this.idstate = idstate;
    }

    public CodeState getSelectedState() {
        return selectedState;
    }

    public void setSelectedState(CodeState selectedState) {
        this.selectedState = selectedState;
    }

    public String getTimeNow()
    {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }
}
