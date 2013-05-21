package cz.i.cis.db.validate;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdudocument;

@Local(DocumentValidateService.class)
public interface DocumentValidateService {
    public String[] validate(Tdudocument document);
}
