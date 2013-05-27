package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tduperson database table.
 *
 */
@Entity
public class Tduperson implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp cdate;

    private Integer cidcisuser;

    private Timestamp ddate;

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

    private Timestamp udate;

    private Integer uidcisuser;

    public Tduperson() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCdate() {
        return this.cdate;
    }

    public void setCdate(Timestamp cdate) {
        this.cdate = cdate;
    }

    public Integer getCidcisuser() {
        return this.cidcisuser;
    }

    public void setCidcisuser(Integer cidcisuser) {
        this.cidcisuser = cidcisuser;
    }

    public Timestamp getDdate() {
        return this.ddate;
    }

    public void setDdate(Timestamp ddate) {
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

    public Timestamp getUdate() {
        return this.udate;
    }

    public void setUdate(Timestamp udate) {
        this.udate = udate;
    }

    public Integer getUidcisuser() {
        return this.uidcisuser;
    }

    public void setUidcisuser(Integer uidcisuser) {
        this.uidcisuser = uidcisuser;
    }


}
