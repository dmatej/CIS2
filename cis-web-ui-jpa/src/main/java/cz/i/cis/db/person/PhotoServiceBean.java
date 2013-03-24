/**
 *
 */
package cz.i.cis.db.person;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 * @author David Matějček
 */
@Stateless
@Local(PhotoService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PhotoServiceBean implements PhotoService {

  @PersistenceContext(unitName="cis")
  private EntityManager em;


  public long getCountOfImages() {
    final TypedQuery<Long> query = em.createNamedQuery("CountOfImages", Long.class);
    return query.getSingleResult();
  }
}
