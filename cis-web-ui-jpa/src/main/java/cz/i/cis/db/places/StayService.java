package cz.i.cis.db.places;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdustay;

@Local
public interface StayService {
  public Tdustay create(Tdustay stay);

  public Tdustay update(Tdustay stay);

  public Tdustay delete(Tdustay stay);

  public List<Tdustay> listStaysForPerson(Integer idPerson);

  public Tdustay findStayById(Integer id);
}
