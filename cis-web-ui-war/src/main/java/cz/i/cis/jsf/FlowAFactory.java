package cz.i.cis.jsf;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowDefinition;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("flow_a")
public class FlowAFactory implements Serializable {

  private static final Logger LOG = LoggerFactory.getLogger(FlowAFactory.class);

  private static final long serialVersionUID = 1L;


  public FlowAFactory() {
    LOG.debug("Initialized.");
  }


  @FlowDefinition
  public Flow defineFlow(final FacesContext context, final FlowBuilder flowBuilder) {
    LOG.debug("defineFlow(context={}, flowBuilder={})", context, flowBuilder);
    final String flowId = "flow_a";
    flowBuilder.id("", flowId);
    flowBuilder.viewNode(flowId, "/" + flowId + "/flow1.xhtml").markAsStartNode();
    flowBuilder.returnNode("exit").fromOutcome("/index");
    flowBuilder.flowCallNode("callB"). //
        flowReference("", "flow_b"). //
        outboundParameter("param1", "#{beanForFlowA.param1}"). //
        outboundParameter("param2", "#{beanForFlowA.param2}"); //
    // inboundParameter("resultFromFlowB", "#{flowScope.resultFromFlowB}");
    return flowBuilder.getFlow();
  }
}
