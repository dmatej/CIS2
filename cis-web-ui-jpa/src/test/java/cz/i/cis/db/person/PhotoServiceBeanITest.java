/**
 *
 */
package cz.i.cis.db.person;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import cz.i.cis.db.test.ITestSupport;


/**
 * @author David Matějček
 */
public class PhotoServiceBeanITest extends ITestSupport {

  @Inject
  private PhotoService service;


  @Test
  public void testCount() {
    assertEquals(0, service.getCountOfImages());
  }
}
