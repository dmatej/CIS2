package cz.i.cis.db.validate;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdustay;

@Local(StayValidateService.class)
public interface StayValidateService {
    public String[] validate(Tdustay stay);
}
