package cz.i.cis.db.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tduperson database table.
 *
 */
@Entity
public class Tduperson implements Serializable, ModifiableStamped {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cdate;

    private Integer cidcisuser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ddate;

    @Temporal(TemporalType.DATE)
    private Date deathdate;

    private String deathplace;

    private String degreeprefix;

    private String degreesuffix;

    private Integer didcisuser;

    private Integer idcisuser;

    private Integer iddeathplace;

    private Integer iddeathstate;

    @Column(name="ididentity_actual")
    private Integer ididentityActual;

    private Integer idimage;

    @Column(name="idperson_original")
    private Integer idpersonOriginal;

    @Column(name="idstay_actual")
    private Integer idstayActual;

    @Column(name="idstayplace_actual")
    private Integer idstayplaceActual;

    private String note;

    private Integer rstatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date udate;

    private Integer uidcisuser;

    public Tduperson() {
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

    public Date getDeathdate() {
        return this.deathdate;
    }

    public void setDeathdate(Date deathdate) {
        this.deathdate = deathdate;
    }

    public String getDeathplace() {
        return this.deathplace;
    }

    public void setDeathplace(String deathplace) {
        this.deathplace = deathplace;
    }

    public String getDegreeprefix() {
        return this.degreeprefix;
    }

    public void setDegreeprefix(String degreeprefix) {
        this.degreeprefix = degreeprefix;
    }

    public String getDegreesuffix() {
        return this.degreesuffix;
    }

    public void setDegreesuffix(String degreesuffix) {
        this.degreesuffix = degreesuffix;
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

    public Integer getIddeathplace() {
        return this.iddeathplace;
    }

    public void setIddeathplace(Integer iddeathplace) {
        this.iddeathplace = iddeathplace;
    }

    public Integer getIddeathstate() {
        return this.iddeathstate;
    }

    public void setIddeathstate(Integer iddeathstate) {
        this.iddeathstate = iddeathstate;
    }

    public Integer getIdidentityActual() {
        return this.ididentityActual;
    }

    public void setIdidentityActual(Integer ididentityActual) {
        this.ididentityActual = ididentityActual;
    }

    public Integer getIdimage() {
        return this.idimage;
    }

    public void setIdimage(Integer idimage) {
        this.idimage = idimage;
    }

    public Integer getIdpersonOriginal() {
        return this.idpersonOriginal;
    }

    public void setIdpersonOriginal(Integer idpersonOriginal) {
        this.idpersonOriginal = idpersonOriginal;
    }

    public Integer getIdstayActual() {
        return this.idstayActual;
    }

    public void setIdstayActual(Integer idstayActual) {
        this.idstayActual = idstayActual;
    }

    public Integer getIdstayplaceActual() {
        return this.idstayplaceActual;
    }

    public void setIdstayplaceActual(Integer idstayplaceActual) {
        this.idstayplaceActual = idstayplaceActual;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getRstatus() {
        return this.rstatus;
    }

    public void setRstatus(Integer rstatus) {
        this.rstatus = rstatus;
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


}
