/**
 *
 */
package cz.i.cis.db.entities;

import java.util.Date;

/**
 * @author David Matějček
 */
public interface Stamped {

  /**
   * @return čas vytvoření záznamu
   */
  Date getCdate();


  /**
   * @param date čas vytvoření záznamu
   */
  void setCdate(Date date);


  /**
   * @return čas smazání záznamu
   */
  Date getDdate();


  /**
   * @param date čas smazání záznamu
   */
  void setDdate(Date date);

}
