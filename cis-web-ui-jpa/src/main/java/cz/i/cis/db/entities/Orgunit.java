package cz.i.cis.db.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the orgunit database table.
 *
 */
@Entity
public class Orgunit implements Serializable, ModifableStamped {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cdate;

    private Integer cidcisuser;

    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ddate;

    private Integer didcisuser;

    private String email;

    private String fax;

    private String note;

    private String phone1;

    private String phone2;

    @Temporal(TemporalType.TIMESTAMP)
    private Date udate;

    private Integer uidcisuser;

    private String unitname;

    private Integer unittype;

    @Temporal(TemporalType.DATE)
    private Date validfrom;

    @Temporal(TemporalType.DATE)
    private Date validto;

    public Orgunit() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCdate() {
        return this.cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Integer getCidcisuser() {
        return this.cidcisuser;
    }

    public void setCidcisuser(Integer cidcisuser) {
        this.cidcisuser = cidcisuser;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDdate() {
        return this.ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    public Integer getDidcisuser() {
        return this.didcisuser;
    }

    public void setDidcisuser(Integer didcisuser) {
        this.didcisuser = didcisuser;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPhone1() {
        return this.phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return this.phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public Date getUdate() {
        return this.udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public Integer getUidcisuser() {
        return this.uidcisuser;
    }

    public void setUidcisuser(Integer uidcisuser) {
        this.uidcisuser = uidcisuser;
    }

    public String getUnitname() {
        return this.unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public Integer getUnittype() {
        return this.unittype;
    }

    public void setUnittype(Integer unittype) {
        this.unittype = unittype;
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
