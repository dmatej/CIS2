package cz.i.cis.db.person;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.Tduperson;

/**
 * Implementace beany pro práci s personou.
 *
 * @author Martin Štulc
 *
 */
@Stateless
@Named
public class PersonServiceBean implements Serializable, PersonService {
  /** serial version id */
  private static final long serialVersionUID = 1L;

  /** entity manager */
  @PersistenceContext(unitName = "cis")
  private EntityManager em;

  public PersonServiceBean() {
  }

  /** {@inheritDoc} */
  @Override
  public Tduperson create(Tduperson person) {
    person.setRstatus(0);
    person.setCidcisuser(0);
    person.setCdate(new Timestamp(0));
    em.persist(person);
    return person;
  }

  /** {@inheritDoc} */
  @Override
  public List<Tduperson> findPersons() {
    final String query = "SELECT p from Tduperson p WHERE p.rstatus=0";
    TypedQuery<Tduperson> query1 = em.createQuery(query, Tduperson.class);
    final List<Tduperson> persons = query1.getResultList();

    return persons;
  }

  /** {@inheritDoc} */
  @Override
  public Tduperson update(Tduperson person) {
    em.merge(person);
    return person;
  }

  /** {@inheritDoc} */
  @Override
  public Tduperson findPersonById(Integer id) {
    final String queryStr = "SELECT p FROM Tduperson p WHERE p.id = :idp";
    TypedQuery<Tduperson> query = em.createQuery(queryStr, Tduperson.class);
    query.setParameter("idp", id);
    final List<Tduperson> persons = query.getResultList();

    if (persons.size() != 1)
      return null;

    return persons.get(0);
  }

  /** {@inheritDoc} */
  @Override
  public Tduperson delete(Tduperson person) {
    person.setRstatus(-1);
    return update(person);
  }

}
