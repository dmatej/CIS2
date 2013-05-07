package cz.i.cis.db.person;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.Tduperson;

@Stateless
@Local(PersonService.class)
public class PersonServiceBean implements Serializable, PersonService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName="cis")
    private EntityManager em;

    public PersonServiceBean()
    { }

    @Override
    public Tduperson create(Tduperson person)
    {
        em.persist(person);
        return person;
    }

    @Override
    public List<Tduperson> getPersons() {
        final String query = "SELECT i from Tduperson i";
        TypedQuery<Tduperson> query1 = em.createQuery(query, Tduperson.class);
        final List<Tduperson> persons = query1.getResultList();

        return persons;
    }

}
