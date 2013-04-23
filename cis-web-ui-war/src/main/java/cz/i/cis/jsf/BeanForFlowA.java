package cz.i.cis.jsf;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@FlowScoped(definingDocumentId = "", value = "flow_a")
public class BeanForFlowA implements Serializable {

  private static final Logger LOG = LoggerFactory.getLogger(BeanForFlowA.class);

  private static final long serialVersionUID = 1L;

  private String param1 = "value1fromA";
  private String param2 = "value2fromA";


  public BeanForFlowA() {
    LOG.debug("Initialized.");
  }


  public String getHelloMessage() {
    LOG.trace("getHelloMessage()");
    return "Hello from " + getClass().getSimpleName() + " which reside in flow 'flow_a'";
  }


  public String getParam1() {
    LOG.trace("getParam1()");
    return param1;
  }


  public void setParam1(String param1) {
    LOG.trace("setParam1(param1={})", param1);
    this.param1 = param1;
  }


  public String getParam2() {
    LOG.trace("getParam2()");
    return param2;
  }


  public void setParam2(String param2) {
    LOG.trace("setParam2(param2={})", param2);
    this.param2 = param2;
  }
}
