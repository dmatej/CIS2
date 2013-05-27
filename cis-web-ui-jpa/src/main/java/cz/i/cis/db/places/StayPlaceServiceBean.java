package cz.i.cis.db.places;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.Tdustayplace;

/**
 * Implementace beany pro práci s místy pobytu.
 *
 * @author Martin Štulc
 *
 */
@Stateless
@Named
public class StayPlaceServiceBean implements Serializable, StayPlaceService {

  /** serial version id */
  private static final long serialVersionUID = 1L;

  /** entity manager */
  @PersistenceContext(unitName = "cis")
  private EntityManager em;

  public StayPlaceServiceBean() {
  }

  /** {@inheritDoc} */
  @Override
  public Tdustayplace create(Tdustayplace stayPlace) {
    stayPlace.setRstatus(0);
    stayPlace.setCidcisuser(0);
    stayPlace.setCdate(new Date());
    em.persist(stayPlace);
    return stayPlace;
  }

  /** {@inheritDoc} */
  @Override
  public Tdustayplace update(Tdustayplace stayPlace) {
    return em.merge(stayPlace);
  }

  /** {@inheritDoc} */
  @Override
  public List<Tdustayplace> findStayPlacesForPerson(Integer idPerson) {
    final String query = "SELECT sp from Tdustayplace sp WHERE sp.idperson=:personID and sp.rstatus=0";
    TypedQuery<Tdustayplace> query1 = em.createQuery(query, Tdustayplace.class);
    query1.setParameter("personID", idPerson);
    final List<Tdustayplace> stays = query1.getResultList();

    return stays;
  }

  /** {@inheritDoc} */
  @Override
  public List<Tdustayplace> findStayPlacesForStay(Integer idStay) {
    final String query = "SELECT sp from Tdustayplace sp WHERE sp.idtdustay=:stayID and sp.rstatus=0";
    TypedQuery<Tdustayplace> query1 = em.createQuery(query, Tdustayplace.class);
    query1.setParameter("stayID", idStay);
    final List<Tdustayplace> stays = query1.getResultList();

    return stays;
  }

  /** {@inheritDoc} */
  @Override
  public Tdustayplace delete(Tdustayplace stayPlace) {
    stayPlace.setRstatus(-1);
    return update(stayPlace);
  }

  /** {@inheritDoc} */
  @Override
  public Tdustayplace findStayPlaceById(Integer id) {
    final String query = "SELECT sp from Tdustayplace sp WHERE sp.id=:idSP";
    TypedQuery<Tdustayplace> query1 = em.createQuery(query, Tdustayplace.class);
    query1.setParameter("idSP", id);
    final List<Tdustayplace> ident = query1.getResultList();

    if (ident.size() != 1)
      return null;

    return ident.get(0);
  }

}
