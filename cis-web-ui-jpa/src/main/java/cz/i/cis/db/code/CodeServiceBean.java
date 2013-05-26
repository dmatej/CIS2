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

/**
 * Implementace beany, která hledá v číselnících
 *
 * @author Martin Štulc
 *
 */
@Stateless
@Named
public class CodeServiceBean implements Serializable, CodeService {

  /** serial id */
  private static final long serialVersionUID = 1L;

  /** entity manager */
  @PersistenceContext(unitName = "cis")
  private EntityManager em;

  public CodeServiceBean() {
  }

  /** {@inheritDoc} */
  @Override
  public CodeDocumenttype findDocumentTypeById(Integer id) {
    final String query = "SELECT cd from CodeDocumenttype cd where cd.id=:codeID";
    TypedQuery<CodeDocumenttype> query1 = em.createQuery(query,
        CodeDocumenttype.class);
    query1.setParameter("codeID", id);
    final List<CodeDocumenttype> res = query1.getResultList();
    if (res.size() != 1)
      return null;

    return res.get(0);
  }

  /** {@inheritDoc} */
  @Override
  public CodePermissiontype findPermissionTypeById(Integer id) {
    final String query = "SELECT cp from CodePermissiontype cp where cp.id=:codeID";
    TypedQuery<CodePermissiontype> query1 = em.createQuery(query,
        CodePermissiontype.class);
    query1.setParameter("codeID", id);
    final List<CodePermissiontype> res = query1.getResultList();
    if (res.size() != 1)
      return null;

    return res.get(0);
  }

  /** {@inheritDoc} */
  @Override
  public CodePurposeofstay findPurposeOfStayById(Integer id) {
    final String query = "SELECT cp from CodePurposeofstay cp where cp.id=:codeID";
    TypedQuery<CodePurposeofstay> query1 = em.createQuery(query,
        CodePurposeofstay.class);
    query1.setParameter("codeID", id);
    final List<CodePurposeofstay> res = query1.getResultList();
    if (res.size() != 1)
      return null;

    return res.get(0);
  }

  /** {@inheritDoc} */
  @Override
  public CodeState findStateById(Integer id) {
    final String query = "SELECT cs from CodeState cs where cs.id=:codeID";
    TypedQuery<CodeState> query1 = em.createQuery(query, CodeState.class);
    query1.setParameter("codeID", id);
    final List<CodeState> res = query1.getResultList();
    if (res.size() != 1)
      return null;

    return res.get(0);
  }

  /** {@inheritDoc} */
  @Override
  public List<CodeDocumenttype> findDocumentTypes() {
    final String query = "SELECT cd from CodeDocumenttype cd";
    TypedQuery<CodeDocumenttype> query1 = em.createQuery(query,
        CodeDocumenttype.class);
    final List<CodeDocumenttype> res = query1.getResultList();
    return res;
  }

  /** {@inheritDoc} */
  @Override
  public List<CodePermissiontype> findPermissionTypes() {
    final String query = "SELECT cp from CodePermissiontype cp";
    TypedQuery<CodePermissiontype> query1 = em.createQuery(query,
        CodePermissiontype.class);
    final List<CodePermissiontype> res = query1.getResultList();
    return res;
  }

  /** {@inheritDoc} */
  @Override
  public List<CodePurposeofstay> findPurposeOfStays() {
    final String query = "SELECT cp from CodePurposeofstay cp";
    TypedQuery<CodePurposeofstay> query1 = em.createQuery(query,
        CodePurposeofstay.class);
    final List<CodePurposeofstay> res = query1.getResultList();
    return res;
  }

  /** {@inheritDoc} */
  @Override
  public List<CodeState> findStates() {
    final String query = "SELECT cs from CodeState cs";
    TypedQuery<CodeState> query1 = em.createQuery(query, CodeState.class);
    final List<CodeState> res = query1.getResultList();
    return res;
  }

}
