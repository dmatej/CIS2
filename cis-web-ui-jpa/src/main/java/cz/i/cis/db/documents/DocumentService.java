package cz.i.cis.db.documents;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.Tdudocument;

@Local
public interface DocumentService {
    public Tdudocument create(Tdudocument document);
    public Tdudocument update(Tdudocument document);

    public List<Tdudocument> getDocumentsForPerson(Integer idPerson);


}
