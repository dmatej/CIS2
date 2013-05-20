package cz.i.cis.db.person;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.Identity;

@Stateless
@Named
public class IdentityServiceBean implements Serializable, IdentityService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "cis")
    private EntityManager em;

    public IdentityServiceBean() {
    }

    @Override
    public Identity create(Identity identity) {
        em.persist(identity);
        return identity;
    }

    @Override
    public List<Identity> getIdentitiesForPerson(Integer idPerson) {
        final String query = "SELECT i from identity i whrere idperson=:personID";
        TypedQuery<Identity> query1 = em.createQuery(query, Identity.class);
        query1.setParameter("personID", idPerson);
        final List<Identity> ident = query1.getResultList();

        return ident;
    }

    @Override
    public Identity update(Identity identity) {
        return em.merge(identity);
    }

}
