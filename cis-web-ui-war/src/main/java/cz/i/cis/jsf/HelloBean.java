/**
 *
 */
package cz.i.cis.jsf;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author David Matějček
 */
@Named
public class HelloBean {
  private static final Logger LOG = LoggerFactory.getLogger(HelloBean.class);

  public String getGreeting() {
    LOG.trace("getGreeting()");
    return "Hello World!";
  }
}
