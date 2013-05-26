package cz.i.cis.db.places;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdustayplace;

@Local
public interface StayPlaceService {
    public Tdustayplace create(Tdustayplace stayPlace);
    public Tdustayplace update(Tdustayplace stayPlace);
    public Tdustayplace delete(Tdustayplace stayPlace);

    public List<Tdustayplace> findStayPlacesForPerson(Integer idPerson);

    public List<Tdustayplace> findStayPlacesForStay(Integer idStay);
    public Tdustayplace findStayPlaceById(Integer id);
}
