package cz.i.cis.other;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cz.i.cis.person.PersonDetailViewBean;

/**
 * Beana, která uržuje informace o oaktuální otevřené záložce.
 *
 * @author Jan Šváb
 *
 */
@ManagedBean(name = "actionsdetailp")
@SessionScoped
public class ActionsDetailPersonBean {
  /**
   * Číslo aktuálně renderované záložky.
   */
  private Integer renderedTab = 0;

  /**
   * Přepne aktuální záložku dle zvolené.
   *
   * @param idTab
   *          nová aktuální záložka
   */
  public void handleTabChange(Integer idTab) {
    renderedTab = idTab;

    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    Object ret = elContext.getELResolver().getValue(elContext, null,
        "personview");

    if (ret != null) {
      ((PersonDetailViewBean) ret).cleanDetailViews();
    }
  }

  /**
   * @return aktuální záložka
   */
  public Integer getRenderedTab() {
    return renderedTab;
  }

  /**
   * Nastaví aktuální záložku.
   *
   * @param renderedTab
   *          aktuální záložka
   */
  public void setRenderedTab(Integer renderedTab) {
    this.renderedTab = renderedTab;
  }
}
