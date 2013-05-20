package cz.i.cis.db.validate;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdustayplace;

@Local(StayPlaceValidateService.class)
public interface StayPlaceValidateService {
    public String[] validate(Tdustayplace stayPlace);
}
