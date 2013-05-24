package cz.i.cis.db.person;

import java.io.Serializable;
import java.sql.Timestamp;
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
    identity.setRstatus(0);
    identity.setIdorgunit(0);
    em.persist(identity);
    return identity;
  }

  @Override
  public List<Identity> findIdentitiesForPerson(Integer idPerson) {
    final String query = "SELECT i from Identity i WHERE i.idperson=:personID and i.rstatus=0";
    TypedQuery<Identity> query1 = em.createQuery(query, Identity.class);
    query1.setParameter("personID", idPerson);
    final List<Identity> ident = query1.getResultList();

    return ident;
  }

  @Override
  public Identity findIdentityById(Integer idIdentity) {
    final String query = "SELECT i from Identity i WHERE i.id=:idIden";
    TypedQuery<Identity> query1 = em.createQuery(query, Identity.class);
    query1.setParameter("idIden", idIdentity);
    final List<Identity> ident = query1.getResultList();

    if (ident.size() != 1)
      return null;

    return ident.get(0);
  }

  @Override
  public Identity update(Identity identity) {
    return em.merge(identity);
  }

  @Override
  public List<Identity> findActualIdentitiesOfPersons() {
    final String queryStr = "SELECT i  FROM Tduperson p, Identity i WHERE p.id = i.idperson and p.rstatus=0";
    TypedQuery<Identity> query = em.createQuery(queryStr, Identity.class);
    final List<Identity> idents = query.getResultList();

    return idents;
  }

  @Override
  public Identity delete(Identity identity) {
    identity.setRstatus(-1);
    return update(identity);
  }

  @Override
  public List<Identity> findIdentitiesByParams(String firstName,
      String lastName, Boolean isMale, String birthNumber) {
    String queryStr = "SELECT i FROM Identity i WHERE i.rstatus=0";
    if (firstName != null)
      queryStr += " and i.firstname LIKE :firstname";

    if (lastName != null)
      queryStr += " and i.lastname LIKE :lastname";

    if (isMale != null)
      queryStr += " and i.sex = :sex";

    if (birthNumber != null)
      queryStr += " and i.birthnumber = :birthnumber";

    TypedQuery<Identity> query = em.createQuery(queryStr, Identity.class);

    if (firstName != null)
      query.setParameter("firstname", '%' + firstName + '%');
    if (lastName != null)
      query.setParameter("lastname", '%' + lastName + '%');
    if (isMale != null)
      query.setParameter("sex", isMale ? "M" : "Z");
    if (birthNumber != null)
      query.setParameter("birthnumber", birthNumber);

    final List<Identity> idents = query.getResultList();

    return idents;
  }

}
