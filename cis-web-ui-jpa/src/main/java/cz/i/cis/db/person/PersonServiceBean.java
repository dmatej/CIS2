package cz.i.cis.db.person;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.Tduperson;

@Stateless
@Named
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
        final String query = "SELECT i from Tduperson i WHERE rstatus=0";
        TypedQuery<Tduperson> query1 = em.createQuery(query, Tduperson.class);
        final List<Tduperson> persons = query1.getResultList();

        return persons;
    }

    @Override
    public Tduperson update(Tduperson person) {
        em.merge(person);
        return person;
    }

    @Override
    public Tduperson findPersonById(Integer id) {
        final String queryStr = "SELECT p FROM Tduperson p WHERE p.id = :idp";
        TypedQuery<Tduperson> query = em.createQuery(queryStr, Tduperson.class);
        query.setParameter("idp", id);
        final List<Tduperson> persons = query.getResultList();

        if(persons.size() != 1) return null;

        return persons.get(0);
    }

    @Override
    public Tduperson delete(Tduperson person) {
        person.setRstatus(-1);
        return update(person);
    }

}
