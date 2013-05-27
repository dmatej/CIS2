package cz.i.cis.db.places;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.Tdustay;

/**
 * Implementace beany pro práci s pobyty.
 *
 * @author Martin Štulc
 *
 */
@Stateless
@Named
public class StayServiceBean implements Serializable, StayService {
  /** serial version id */
  private static final long serialVersionUID = 1L;

  /** entity manager */
  @PersistenceContext(unitName = "cis")
  private EntityManager em;

  public StayServiceBean() {
  }

  /** {@inheritDoc} */
  @Override
  public Tdustay create(Tdustay stay) {
    stay.setRstatus(0);
    stay.setCidcisuser(0);
    stay.setCdate(new Timestamp(0));
    em.persist(stay);
    return stay;
  }

  /** {@inheritDoc} */
  @Override
  public Tdustay update(Tdustay stay) {
    return em.merge(stay);
  }

  /** {@inheritDoc} */
  @Override
  public List<Tdustay> listStaysForPerson(Integer idPerson) {
    final String query = "SELECT s FROM Tdustay s WHERE s.idperson=:personID and s.rstatus=0";
    TypedQuery<Tdustay> query1 = em.createQuery(query, Tdustay.class);
    query1.setParameter("personID", idPerson);
    final List<Tdustay> stays = query1.getResultList();

    return stays;
  }

  /** {@inheritDoc} */
  @Override
  public Tdustay delete(Tdustay stay) {
    stay.setRstatus(-1);
    return update(stay);
  }

  /** {@inheritDoc} */
  @Override
  public Tdustay findStayById(Integer id) {
    final String query = "SELECT s from Tdustay s WHERE s.id=:idS";
    TypedQuery<Tdustay> query1 = em.createQuery(query, Tdustay.class);
    query1.setParameter("idS", id);
    final List<Tdustay> ident = query1.getResultList();

    if (ident.size() != 1)
      return null;

    return ident.get(0);
  }

}
