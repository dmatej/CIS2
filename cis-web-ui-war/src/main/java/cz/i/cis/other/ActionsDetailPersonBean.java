package cz.i.cis.other;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cz.i.cis.person.PersonDetailViewBean;

@ManagedBean(name="actionsdetailp")
@SessionScoped
public class ActionsDetailPersonBean {
    private final Integer TABIDENTITY = 1;
    private final Integer TABDOKLADY = 2;
    private final Integer TABPOBYTY = 3;

    private Integer renderedTab = 0;

    public void handleTabChange(Integer idTab) {
        renderedTab = idTab;

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        Object ret = elContext.getELResolver()
            .getValue(elContext, null, "personview");

        if(ret != null)
        {
          ((PersonDetailViewBean) ret).cleanDetailViews();
        }
    }

    public Integer getRenderedTab() {
        return renderedTab;
    }

    public void setRenderedTab(Integer renderedTab) {
        this.renderedTab = renderedTab;
    }
}
