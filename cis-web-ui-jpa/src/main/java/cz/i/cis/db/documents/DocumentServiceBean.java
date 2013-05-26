package cz.i.cis.db.documents;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.Tdudocument;

@Stateless
@Named
public class DocumentServiceBean implements Serializable, DocumentService {

  private static final long serialVersionUID = 1L;

  @PersistenceContext(unitName = "cis")
  private EntityManager em;

  public DocumentServiceBean() {
  }

  /** {@inheritDoc} */
  @Override
  public Tdudocument create(Tdudocument document) {
    document.setRstatus(0);
    document.setCidcisuser(0);
    document.setCdate(new Timestamp(0));
    em.persist(document);
    return document;
  }

  /** {@inheritDoc} */
  @Override
  public List<Tdudocument> findDocumentsForPerson(Integer idPerson) {
    final String query = "SELECT d FROM Tdudocument d WHERE d.idperson=:personID and d.rstatus=0";
    TypedQuery<Tdudocument> query1 = em.createQuery(query, Tdudocument.class);
    query1.setParameter("personID", idPerson);
    final List<Tdudocument> docs = query1.getResultList();

    return docs;
  }

  /** {@inheritDoc} */
  @Override
  public Tdudocument update(Tdudocument document) {
    return em.merge(document);
  }

  /** {@inheritDoc} */
  @Override
  public Tdudocument delete(Tdudocument document) {
    document.setRstatus(-1);
    return update(document);
  }

  /** {@inheritDoc} */
  @Override
  public Tdudocument findDocumentsById(Integer id) {
    final String query = "SELECT d from Tdudocument d WHERE d.id=:idDoc";
    TypedQuery<Tdudocument> query1 = em.createQuery(query, Tdudocument.class);
    query1.setParameter("idDoc", id);
    final List<Tdudocument> ident = query1.getResultList();

    if (ident.size() != 1)
      return null;

    return ident.get(0);
  }

}
