package cz.i.cis.db.validate;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tduperson;

@Local(PersonValidateService.class)
public interface PersonValidateService {
    public Boolean validate(Tduperson person);
}
