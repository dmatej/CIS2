package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tdudocument database table.
 *
 */
@Entity
public class Tdudocument implements Serializable {
    private static final long serialVersionUID = 1L;

    private Timestamp cdate;

    private Integer cidcisuser;

    @Temporal(TemporalType.DATE)
    private Date dateofcancel;

    @Temporal(TemporalType.DATE)
    private Date dateofreceipt;

    @Temporal(TemporalType.DATE)
    private Date dateofrenewal;

    private Timestamp ddate;

    private Integer didcisuser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idcisuser;

    private Integer idcodedocumenttype;

    private Integer ididentity;

    private Integer idorgunitissued;

    private Integer idperson;

    @Column(name="idperson_original")
    private Integer idpersonOriginal;

    private Integer idstateissued;

    private Integer idtdustay;

    @Temporal(TemporalType.DATE)
    private Date issued;

    private String note;

    private String number;

    private Integer rstatus;

    private Timestamp udate;

    private Integer uidcisuser;

    @Temporal(TemporalType.DATE)
    private Date validfrom;

    @Temporal(TemporalType.DATE)
    private Date validto;

    private String visaapplicationnumber;

    public Tdudocument() {
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

    public Date getDateofcancel() {
        return this.dateofcancel;
    }

    public void setDateofcancel(Date dateofcancel) {
        this.dateofcancel = dateofcancel;
    }

    public Date getDateofreceipt() {
        return this.dateofreceipt;
    }

    public void setDateofreceipt(Date dateofreceipt) {
        this.dateofreceipt = dateofreceipt;
    }

    public Date getDateofrenewal() {
        return this.dateofrenewal;
    }

    public void setDateofrenewal(Date dateofrenewal) {
        this.dateofrenewal = dateofrenewal;
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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdcisuser() {
        return this.idcisuser;
    }

    public void setIdcisuser(Integer idcisuser) {
        this.idcisuser = idcisuser;
    }

    public Integer getIdcodedocumenttype() {
        return this.idcodedocumenttype;
    }

    public void setIdcodedocumenttype(Integer idcodedocumenttype) {
        this.idcodedocumenttype = idcodedocumenttype;
    }

    public Integer getIdidentity() {
        return this.ididentity;
    }

    public void setIdidentity(Integer ididentity) {
        this.ididentity = ididentity;
    }

    public Integer getIdorgunitissued() {
        return this.idorgunitissued;
    }

    public void setIdorgunitissued(Integer idorgunitissued) {
        this.idorgunitissued = idorgunitissued;
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

    public Integer getIdstateissued() {
        return this.idstateissued;
    }

    public void setIdstateissued(Integer idstateissued) {
        this.idstateissued = idstateissued;
    }

    public Integer getIdtdustay() {
        return this.idtdustay;
    }

    public void setIdtdustay(Integer idtdustay) {
        this.idtdustay = idtdustay;
    }

    public Date getIssued() {
        return this.issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getVisaapplicationnumber() {
        return this.visaapplicationnumber;
    }

    public void setVisaapplicationnumber(String visaapplicationnumber) {
        this.visaapplicationnumber = visaapplicationnumber;
    }

}