package cz.i.cis.db.person;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdustayplace;

@Local
public interface StayPlaceService {
    public Tdustayplace create(Tdustayplace stayPlace);

    public Tdustayplace update(Tdustayplace stayPlace);

    public List<Tdustayplace> getStayPlacesForPerson(Integer idPerson);

    public List<Tdustayplace> getStayPlacesForStay(Integer idStay);
}
