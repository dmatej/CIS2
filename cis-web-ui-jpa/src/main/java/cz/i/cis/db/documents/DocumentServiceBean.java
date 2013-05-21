package cz.i.cis.db.documents;

import java.io.Serializable;
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

    @Override
    public Tdudocument create(Tdudocument document) {
        em.persist(document);
        return document;
    }

    @Override
    public List<Tdudocument> getDocumentsForPerson(Integer idPerson) {
        final String query = "SELECT i from tdudocument i where idperson=:personID";
        TypedQuery<Tdudocument> query1 = em.createQuery(query, Tdudocument.class);
        query1.setParameter("personID", idPerson);
        final List<Tdudocument> docs = query1.getResultList();

        return docs;
    }


    @Override
    public Tdudocument update(Tdudocument document) {
        return em.merge(document);
    }


}
