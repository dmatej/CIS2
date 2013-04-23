package cz.i.cis.db.person;

import java.util.List;

import cz.i.cis.db.entities.Identity;

public interface PersonService {
    public Identity create(String firstname, String lastname, String birthnumber, String birthplace);

    public List<Identity> getPersons();
}
