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
 * The persistent class for the cisuserrole database table.
 *
 */
@Entity
public class Cisuserrole implements Serializable, Stamped {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cdate;

    private Integer cidcisuser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ddate;

    private Integer didcisuser;

    private Integer idcisuser;

    private Integer idrole;

    @Temporal(TemporalType.DATE)
    private Date validfrom;

    @Temporal(TemporalType.DATE)
    private Date validto;

    public Cisuserrole() {
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

    public Integer getIdcisuser() {
        return this.idcisuser;
    }

    public void setIdcisuser(Integer idcisuser) {
        this.idcisuser = idcisuser;
    }

    public Integer getIdrole() {
        return this.idrole;
    }

    public void setIdrole(Integer idrole) {
        this.idrole = idrole;
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
