package cz.i.cis.db.code;

import java.util.List;

import javax.ejb.Local;

import cz.i.cis.db.entities.CodeDocumenttype;
import cz.i.cis.db.entities.CodePermissiontype;
import cz.i.cis.db.entities.CodePurposeofstay;
import cz.i.cis.db.entities.CodeState;

@Local
public interface CodeService {
    public CodeDocumenttype findDocumentTypeById(Integer id);
    public CodePermissiontype findPermissionTypeById(Integer id);
    public CodePurposeofstay findPurposeOfStayById(Integer id);
    public CodeState findStateById(Integer id);

    public List<CodeDocumenttype> findDocumentTypes();
    public List<CodePermissiontype> findPermissionTypes();
    public List<CodePurposeofstay> findPurposeOfStays();
    public List<CodeState> findStates();


}
