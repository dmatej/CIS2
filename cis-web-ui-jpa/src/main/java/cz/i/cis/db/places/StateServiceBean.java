package cz.i.cis.db.places;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.i.cis.db.entities.CodeState;

@Stateless
@Local(StateService.class)
public class StateServiceBean implements StateService {

    @PersistenceContext(unitName="cis")
    private EntityManager em;

    @Override
    public CodeState create(String name, String nameCZ, String nameEN,
            String nameFull, String nameNativ, String code, Integer idstate) {

        CodeState cs = new CodeState();

        cs.setName(name);
        cs.setNameCz(nameCZ);
        cs.setNameEn(nameEN);
        cs.setNameFull(nameFull);
        cs.setNameNativ(nameNativ);
        cs.setCode(code);
        cs.setIdstate(idstate);
        cs.setCodeIcao(code); //TODO opravit
        cs.setValidfrom(new Date()); //TODO opravit
        cs.setValidto(new Date()); //TODO opravit
        em.persist(cs);

        return cs;
    }

    @Override
    public List<CodeState> listStates() {
        final String queryCS = "SELECT s FROM CodeState s";
        TypedQuery<CodeState> query = em.createQuery(queryCS, CodeState.class);
        final List<CodeState> states = query.getResultList();

        return states;
    }

    @Override
    public boolean exists(String code, Integer idstate) {
        final String queryCS = "SELECT s FROM CodeState s WHERE s.code = :statecode OR s.idstate = :stateID";
        TypedQuery<CodeState> query = em.createQuery(queryCS, CodeState.class);
        query.setParameter("statecode", code);
        query.setParameter("stateID", idstate);
        final List<CodeState> states = query.getResultList();

        return states.size() > 0;
    }

    @Override
    public CodeState loadState(int id) {
        final String queryCS = "SELECT s FROM CodeState s WHERE s.id = :idst";
        TypedQuery<CodeState> query = em.createQuery(queryCS, CodeState.class);
        query.setParameter("idst", id);
        final List<CodeState> states = query.getResultList();

        if(states.size() == 0)
        {
            //TODO osetrit
            return null;
        }
        else
        {
            return states.get(0);
        }
    }
}
