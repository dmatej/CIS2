package cz.i.cis.db.code;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.CodeDocumenttype;
import cz.i.cis.db.entities.CodePermissiontype;
import cz.i.cis.db.entities.CodePurposeofstay;
import cz.i.cis.db.entities.CodeState;

@Stateless
@Named
public class CodeServiceBean implements Serializable, CodeService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "cis")
    private EntityManager em;

    public CodeServiceBean() {
    }

    @Override
    public CodeDocumenttype getDocumentTypeById(Integer id) {
        final String query = "SELECT i from code_documenttype i where i.id=:codeID";
        TypedQuery<CodeDocumenttype> query1 = em.createQuery(query,
                CodeDocumenttype.class);
        query1.setParameter("codeID", id);
        final List<CodeDocumenttype> res = query1.getResultList();
        if (res.size() != 1)
            return null;

        return res.get(0);
    }

    @Override
    public CodePermissiontype getPermissionTypeById(Integer id) {
        final String query = "SELECT i from code_permissiontype i where i.id=:codeID";
        TypedQuery<CodePermissiontype> query1 = em.createQuery(query,
                CodePermissiontype.class);
        query1.setParameter("codeID", id);
        final List<CodePermissiontype> res = query1.getResultList();
        if (res.size() != 1)
            return null;

        return res.get(0);
    }

    @Override
    public CodePurposeofstay getPurposeOfStayById(Integer id) {
        final String query = "SELECT i from code_purmoseofstay i where i.id=:codeID";
        TypedQuery<CodePurposeofstay> query1 = em.createQuery(query,
                CodePurposeofstay.class);
        query1.setParameter("codeID", id);
        final List<CodePurposeofstay> res = query1.getResultList();
        if (res.size() != 1)
            return null;

        return res.get(0);
    }

    @Override
    public CodeState getStateById(Integer id) {
        final String query = "SELECT i from code_state i where i.id=:codeID";
        TypedQuery<CodeState> query1 = em.createQuery(query, CodeState.class);
        query1.setParameter("codeID", id);
        final List<CodeState> res = query1.getResultList();
        if (res.size() != 1)
            return null;

        return res.get(0);
    }

}
