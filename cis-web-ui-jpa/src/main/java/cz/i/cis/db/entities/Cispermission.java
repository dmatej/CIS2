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
 * The persistent class for the cispermission database table.
 */
@Entity
public class Cispermission implements Serializable, ModifiableStamped {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String annotation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cdate;

    private Integer cidcisuser;

    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ddate;

    private String description;

    private Integer didcisuser;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date udate;

    private Integer uidcisuser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date validto;

    public Cispermission() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnnotation() {
        return this.annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDidcisuser() {
        return this.didcisuser;
    }

    public void setDidcisuser(Integer didcisuser) {
        this.didcisuser = didcisuser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
