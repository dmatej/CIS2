package cz.i.cis.db.person;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tduperson;

@Local(PersonService.class)
public interface PersonService {
    public Tduperson create(Tduperson person);
    public Tduperson update(Tduperson person);
    public Tduperson delete(Tduperson person);

    public List<Tduperson> getPersons();

    public Tduperson findPersonById(Integer id);
}
