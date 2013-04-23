package cz.i.cis.db.person;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.Identity;

@Stateless
@Local(PersonService.class)
public class PersonServiceBean implements Serializable, PersonService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName="cis")
    private EntityManager em;

    public PersonServiceBean()
    { }

    @Override
    public Identity create(String firstname, String lastname, String birthnumber, String birthplace)
    {
        Identity identity = new Identity();

        identity.setFirstname(firstname);
        identity.setLastname(lastname);
        identity.setBirthnumber(birthnumber);
        identity.setBirthplace(birthplace);

        identity.setOthernames("ostatni jmena");
        identity.setBirthname("Jan Šváb");
        identity.setRstatus(0);
        identity.setIdstateofbirth(0);
        identity.setValidfrom(new Date());
        identity.setValidto(new Date());
        identity.setIdstate(0);
        identity.setBirthdate("10082012");
        identity.setIdorgunit(0);
        identity.setIdevidence(0);

        em.persist(identity);

        return identity;
    }

    @Override
    public List<Identity> getPersons() {
        final String query = "SELECT i from Identity i";
        TypedQuery<Identity> query1 = em.createQuery(query, Identity.class);
        final List<Identity> identities = query1.getResultList();

        return identities;
    }
}
