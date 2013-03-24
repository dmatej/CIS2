/**
 *
 */
package cz.i.cis.db.person;

import static org.junit.Assert.assertEquals;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import org.junit.Test;

import cz.i.cis.db.test.ITestSupport;


/**
 * @author David Matějček
 */
@ManagedBean
public class PhotoServiceBeanITest extends ITestSupport {

  @EJB
  private PhotoService service;


  @Test
  public void testCount() {
    assertEquals(0, service.getCountOfImages());
  }
}
