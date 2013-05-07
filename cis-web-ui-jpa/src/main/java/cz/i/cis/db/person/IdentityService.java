package cz.i.cis.db.person;

import java.util.List;

import cz.i.cis.db.entities.Identity;

public interface IdentityService {
    public Identity create(Identity identity);

    public List<Identity> getIdentitiesForPerson(Integer idPerson);
}
