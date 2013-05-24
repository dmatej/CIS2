package cz.i.cis.other;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ManagedBean(name = "actionsdetailp")
@SessionScoped
public class ActionsDetailPersonBean {
    private final Integer TABIDENTITY = 1;
    private final Integer TABDOKLADY = 2;
    private final Integer TABPOBYTY = 3;

    private Integer renderedTab = 0;

    private Boolean rqNewIdentity = false;

    public void requestForNewIdentity()
    {
        rqNewIdentity = !rqNewIdentity;
    }

    public Boolean getRqNewIdentity() {
        return rqNewIdentity;
    }

    public void handleTabChange(Integer idTab) {
        renderedTab = idTab;
        if(renderedTab != TABIDENTITY) rqNewIdentity = false;
    }

    public Integer getRenderedTab() {
        return renderedTab;
    }

    public void setRenderedTab(Integer renderedTab) {
        this.renderedTab = renderedTab;
    }
}
