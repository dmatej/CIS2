package cz.i.cis.db.person;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cz.i.cis.db.entities.Tduperson;

/**
 * Implementace beany pro slučování person do jedné.
 *
 * @author Martin Štulc
 *
 */
@Stateless
@Named
public class CollapsePersonServiceBean implements Serializable,
    CollapsePersonService {

  /** serial version id */
  private static final long serialVersionUID = 1L;

  /** entity manager */
  @PersistenceContext(unitName = "cis")
  private EntityManager em;

  /** beana pro práci s personou */
  @EJB
  private PersonServiceBean personServiceBean;

  public CollapsePersonServiceBean() {
  }

  /** {@inheritDoc} */
  @Override
  public Tduperson collapsePersons(Tduperson mainPerson,
      Tduperson importedPerson) {
    if (mainPerson.getIdidentityActual() == null) {
      mainPerson.setIdidentityActual(importedPerson.getIdidentityActual());
    }
    if (mainPerson.getDeathdate() == null) {
      mainPerson.setDeathdate(importedPerson.getDeathdate());
    }
    if (mainPerson.getDeathplace() == null) {
      mainPerson.setDeathplace(importedPerson.getDeathplace());
    }
    if (mainPerson.getDegreeprefix() == null) {
      mainPerson.setDegreeprefix(importedPerson.getDegreeprefix());
    }
    if (mainPerson.getDegreesuffix() == null) {
      mainPerson.setDegreesuffix(importedPerson.getDegreesuffix());
    }
    if (mainPerson.getIddeathplace() == null) {
      mainPerson.setIddeathplace(importedPerson.getIddeathplace());
    }
    if (mainPerson.getIddeathstate() == null) {
      mainPerson.setIddeathstate(importedPerson.getIddeathstate());
    }
    if (mainPerson.getIdimage() == null) {
      mainPerson.setIdimage(importedPerson.getIdimage());
    }
    if (mainPerson.getIdstayActual() == null) {
      mainPerson.setIdstayActual(importedPerson.getIdstayActual());
    }
    if (mainPerson.getIdstayplaceActual() == null) {
      mainPerson.setIdstayplaceActual(importedPerson.getIdstayplaceActual());
    }
    if (mainPerson.getNote() == null) {
      mainPerson.setNote(importedPerson.getNote());
    }

    moveIdentity(mainPerson, importedPerson);
    moveStay(mainPerson, importedPerson);
    moveStayPlace(mainPerson, importedPerson);

    personServiceBean.update(mainPerson);
    personServiceBean.delete(importedPerson);
    return mainPerson;
  }

  /**
   * Přesune místa pobytu od staré k nové personě.
   *
   * @param mainPerson
   *          nová persona
   * @param importedPerson
   *          stará persona
   * @return počet přesunutých míst pobytu
   */
  private Integer moveStayPlace(Tduperson mainPerson, Tduperson importedPerson) {
    final String queryStr = "UPDATE Tdustayplace sp SET sp.idperson = :idPerNew WHERE"
        + " sp.rstatus=0 and sp.idperson = :idPerOld";
    Query query = em.createQuery(queryStr);
    query.setParameter("idPerNew", mainPerson.getId());
    query.setParameter("idPerOld", importedPerson.getId());
    return query.executeUpdate();

  }

  /**
   * Přesune pobyty od staré k nové personě.
   *
   * @param mainPerson
   *          nová persona
   * @param importedPerson
   *          stará persona
   * @return počet přesunutých pobytů
   */
  private Integer moveStay(Tduperson mainPerson, Tduperson importedPerson) {
    final String queryStr = "UPDATE Tdustay s SET s.idperson = :idPerNew WHERE"
        + " s.rstatus=0 and s.idperson = :idPerOld";
    Query query = em.createQuery(queryStr);
    query.setParameter("idPerNew", mainPerson.getId());
    query.setParameter("idPerOld", importedPerson.getId());
    return query.executeUpdate();

  }

  /**
   * Přesune identity od staré k nové personě.
   *
   * @param mainPerson
   *          nová persona
   * @param importedPerson
   *          stará persona
   * @return počet přesunutých identit
   */
  private Integer moveIdentity(Tduperson mainPerson, Tduperson importedPerson) {
    final String queryStr = "UPDATE Identity i SET i.idperson = :idPerNew WHERE"
        + " i.rstatus=0 and i.idperson = :idPerOld";
    Query query = em.createQuery(queryStr);
    query.setParameter("idPerNew", mainPerson.getId());
    query.setParameter("idPerOld", importedPerson.getId());
    return query.executeUpdate();
  }

}
