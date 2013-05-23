package cz.i.cis.db.person;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.Tdustayplace;

@Stateless
@Named
public class StayPlaceServiceBean implements Serializable, StayPlaceService {

  private static final long serialVersionUID = 1L;

  @PersistenceContext(unitName = "cis")
  private EntityManager em;

  public StayPlaceServiceBean() {
  }

  @Override
  public Tdustayplace create(Tdustayplace stayPlace) {
    stayPlace.setRstatus(0);
    stayPlace.setCidcisuser(0);
    stayPlace.setCdate(new Timestamp(0));
    em.persist(stayPlace);
    return stayPlace;
  }

  @Override
  public Tdustayplace update(Tdustayplace stayPlace) {
    return em.merge(stayPlace);
  }

  @Override
  public List<Tdustayplace> findStayPlacesForPerson(Integer idPerson) {
    final String query = "SELECT sp from Tdustayplace sp WHERE sp.idperson=:personID and sp.rstatus=0";
    TypedQuery<Tdustayplace> query1 = em.createQuery(query, Tdustayplace.class);
    query1.setParameter("personID", idPerson);
    final List<Tdustayplace> stays = query1.getResultList();

    return stays;
  }

  @Override
  public List<Tdustayplace> findStayPlacesForStay(Integer idStay) {
    final String query = "SELECT sp from Tdustayplace sp WHERE sp.idtdustay=:stayID and sp.rstatus=0";
    TypedQuery<Tdustayplace> query1 = em.createQuery(query, Tdustayplace.class);
    query1.setParameter("stayID", idStay);
    final List<Tdustayplace> stays = query1.getResultList();

    return stays;
  }

  @Override
  public Tdustayplace delete(Tdustayplace stayPlace) {
    stayPlace.setRstatus(-1);
    return update(stayPlace);
  }

}
