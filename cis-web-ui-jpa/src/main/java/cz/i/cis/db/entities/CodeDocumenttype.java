package cz.i.cis.db.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the code_documenttype database table.
 *
 */
@Entity
@Table(name="code_documenttype")
public class CodeDocumenttype implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    private String note;

    private Short rank;

    @Temporal(TemporalType.DATE)
    private Date validfrom;

    @Temporal(TemporalType.DATE)
    private Date validto;

    public CodeDocumenttype() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Short getRank() {
        return this.rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public Date getValidfrom() {
        return this.validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public Date getValidto() {
        return this.validto;
    }

    public void setValidto(Date validto) {
        this.validto = validto;
    }

}
