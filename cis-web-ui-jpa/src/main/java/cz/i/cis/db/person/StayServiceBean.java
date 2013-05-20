package cz.i.cis.db.person;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.Tdustay;

@Stateless
@Named
public class StayServiceBean implements Serializable, StayService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName="cis")
    private EntityManager em;

    public StayServiceBean()
    { }

    @Override
    public Tdustay create(Tdustay stay)
    {
        em.persist(stay);
        return stay;
    }



    @Override
    public Tdustay update(Tdustay stay) {
        return em.merge(stay);
    }

    @Override
    public List<Tdustay> getStaysForPerson(Integer idPerson) {
        final String query = "SELECT i from tdustay i whrere idperson=:personID";
        TypedQuery<Tdustay> query1 = em.createQuery(query, Tdustay.class);
        query1.setParameter("personID", idPerson);
        final List<Tdustay> stays = query1.getResultList();

        return stays;
    }

}
