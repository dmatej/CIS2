/**
 *
 */
package cz.i.cis.db.entities;

import java.util.Date;

/**
 * @author David Matějček
 */
public interface ModifiableStamped extends Stamped {

  /**
   * @return čas poslední změny záznamu
   */
  Date getUdate();


  /**
   * @param date čas poslední změny záznamu
   */
  void setUdate(Date date);
}
