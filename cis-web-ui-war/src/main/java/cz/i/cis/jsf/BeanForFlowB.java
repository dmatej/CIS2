package cz.i.cis.jsf;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@FlowScoped(definingDocumentId = "", value = "flow_b")
public class BeanForFlowB implements Serializable {

  private static final Logger LOG = LoggerFactory.getLogger(BeanForFlowB.class);
  private static final long serialVersionUID = 1L;
  private String returnedValue;


  public BeanForFlowB() {
    LOG.debug("Initialized.");
  }


  public String getHelloMessage() {
    return "Hello from " + getClass().getSimpleName() + " which reside in flow 'flow_b'";
  }


  public String getReturnedValue() {
    return returnedValue;
  }


  public void setReturnedValue(String returnedValue) {
    this.returnedValue = returnedValue;
  }
}
