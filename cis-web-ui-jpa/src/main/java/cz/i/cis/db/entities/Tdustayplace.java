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
 * The persistent class for the tdustayplace database table.
 *
 */
@Entity
public class Tdustayplace implements Serializable, ModifiableStamped {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cdate;

    private Integer cidcisuser;

    @Temporal(TemporalType.DATE)
    private Date datefrom;

    @Temporal(TemporalType.DATE)
    private Date dateto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ddate;

    private Integer didcisuser;

    private String address;

    private Integer idorgunit;

    private Integer idperson;

    @Column(name="idperson_original")
    private Integer idpersonOriginal;

    private Integer idtdustay;

    private String note;

    private Integer rstatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date udate;

    private Integer uidcisuser;

    public Tdustayplace() {
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

    public Date getDatefrom() {
        return this.datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return this.dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIdorgunit() {
        return this.idorgunit;
    }

    public void setIdorgunit(Integer idorgunit) {
        this.idorgunit = idorgunit;
    }

    public Integer getIdperson() {
        return this.idperson;
    }

    public void setIdperson(Integer idperson) {
        this.idperson = idperson;
    }

    public Integer getIdpersonOriginal() {
        return this.idpersonOriginal;
    }

    public void setIdpersonOriginal(Integer idpersonOriginal) {
        this.idpersonOriginal = idpersonOriginal;
    }

    public Integer getIdtdustay() {
        return this.idtdustay;
    }

    public void setIdtdustay(Integer idtdustay) {
        this.idtdustay = idtdustay;
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
