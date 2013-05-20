package cz.i.cis.db.person;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdustay;

@Local
public interface StayService {
    public Tdustay create(Tdustay stay);
    public Tdustay update(Tdustay stay);

    public List<Tdustay> getStaysForPerson(Integer idPerson);
}
