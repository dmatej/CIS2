package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tdustayplace database table.
 *
 */
@Entity
public class Tdustayplace implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp cdate;

    private Integer cidcisuser;

    @Temporal(TemporalType.DATE)
    private Date datefrom;

    @Temporal(TemporalType.DATE)
    private Date dateto;

    private Timestamp ddate;

    private Integer didcisuser;

    private Integer idaddress;

    private Integer idorgunit;

    private Integer idperson;

    @Column(name="idperson_original")
    private Integer idpersonOriginal;

    private Integer idtdustay;

    private String note;

    private Integer rstatus;

    private Timestamp udate;

    private Integer uidcisuser;

    public Tdustayplace() {
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

    public Timestamp getDdate() {
        return this.ddate;
    }

    public void setDdate(Timestamp ddate) {
        this.ddate = ddate;
    }

    public Integer getDidcisuser() {
        return this.didcisuser;
    }

    public void setDidcisuser(Integer didcisuser) {
        this.didcisuser = didcisuser;
    }

    public Integer getIdaddress() {
        return this.idaddress;
    }

    public void setIdaddress(Integer idaddress) {
        this.idaddress = idaddress;
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