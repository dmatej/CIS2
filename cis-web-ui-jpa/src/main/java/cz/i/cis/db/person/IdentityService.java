package cz.i.cis.db.person;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Identity;

@Local
public interface IdentityService {
  public Identity create(Identity identity);

  public Identity update(Identity identity);

  public Identity delete(Identity identity);

  public List<Identity> findIdentitiesForPerson(Integer idPerson);

  public List<Identity> findIdentitiesByParams(String firstName,
      String lastName, Boolean isMale, String birthNumber);

  public List<Identity> findActualIdentitiesOfPersons();

  public Identity findIdentityById(Integer idIdentity);

}
