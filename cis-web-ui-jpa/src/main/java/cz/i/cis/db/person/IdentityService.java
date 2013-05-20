package cz.i.cis.db.person;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Identity;

@Local
public interface IdentityService {
    public Identity create(Identity identity);
    public Identity update(Identity identity);

    public List<Identity> getIdentitiesForPerson(Integer idPerson);

    public List<Identity> getActualIdentitiesOfPersons();

    public Identity getConcreteIdentityForPerson(Integer idIdentity);
}
