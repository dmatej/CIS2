package cz.i.cis.db.person;

import java.io.Serializable;
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

    @PersistenceContext(unitName="cis")
    private EntityManager em;

    public StayPlaceServiceBean()
    { }

    @Override
    public Tdustayplace create(Tdustayplace stayPlace)
    {
        em.persist(stayPlace);
        return stayPlace;
    }



    @Override
    public Tdustayplace update(Tdustayplace stayPlace) {
        return em.merge(stayPlace);
    }

    @Override
    public List<Tdustayplace> getStayPlacesForPerson(Integer idPerson) {
        final String query = "SELECT i from tdustayplace i whrere idperson=:personID";
        TypedQuery<Tdustayplace> query1 = em.createQuery(query, Tdustayplace.class);
        query1.setParameter("personID", idPerson);
        final List<Tdustayplace> stays = query1.getResultList();

        return stays;
    }

    @Override
    public List<Tdustayplace> getStayPlacesForStay(Integer idStay) {
        final String query = "SELECT i from tdustayplace i whrere idtdustay=:stayID";
        TypedQuery<Tdustayplace> query1 = em.createQuery(query, Tdustayplace.class);
        query1.setParameter("stayID", idStay);
        final List<Tdustayplace> stays = query1.getResultList();

        return stays;
    }

}
