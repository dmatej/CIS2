package cz.i.cis.db.validate;

import javax.ejb.Local;

import cz.i.cis.db.entities.Identity;

@Local(IdentityValidateService.class)
public interface IdentityValidateService {
    public String[] validate(Identity identity);
}
