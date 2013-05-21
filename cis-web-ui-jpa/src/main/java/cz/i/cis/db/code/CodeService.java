package cz.i.cis.db.code;

import javax.ejb.Local;

import cz.i.cis.db.entities.CodeDocumenttype;
import cz.i.cis.db.entities.CodePermissiontype;
import cz.i.cis.db.entities.CodePurposeofstay;
import cz.i.cis.db.entities.CodeState;

@Local
public interface CodeService {
    public CodeDocumenttype getDocumentTypeById(Integer id);
    public CodePermissiontype getPermissionTypeById(Integer id);
    public CodePurposeofstay getPurposeOfStayById(Integer id);
    public CodeState getStateById(Integer id);


}
