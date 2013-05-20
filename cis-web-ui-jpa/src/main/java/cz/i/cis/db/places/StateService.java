package cz.i.cis.db.places;

import java.util.List;

import cz.i.cis.db.entities.CodeState;

public interface StateService {
    public CodeState create(String name, String nameCZ, String nameEN, String nameFull, String nameNativ, String code, Integer idstate);

    public List<CodeState> listStates();

    public boolean exists(String code, Integer idstate);

    public CodeState loadState(int id);
}
