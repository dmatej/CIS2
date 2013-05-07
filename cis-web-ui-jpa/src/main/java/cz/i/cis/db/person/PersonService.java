package cz.i.cis.db.person;

import java.util.List;

import cz.i.cis.db.entities.Tduperson;

public interface PersonService {
    public Tduperson create(Tduperson person);

    public List<Tduperson> getPersons();
}
