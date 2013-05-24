package cz.i.cis.other;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("tabcontrol")
@RequestScoped
public class TabControlBean {
    private Integer renderedTab = 0;

    public void handleTabChange(Integer idTab) {
        renderedTab = idTab;
    }

    public Integer getRenderedTab() {
        return renderedTab;
    }

    public void setRenderedTab(Integer renderedTab) {
        this.renderedTab = renderedTab;
    }
}
