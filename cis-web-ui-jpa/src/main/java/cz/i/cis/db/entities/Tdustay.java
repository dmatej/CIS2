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
 * The persistent class for the tdustay database table.
 *
 */
@Entity
public class Tdustay implements Serializable, ModifiableStamped {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date arrivaldate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cdate;

    private Integer cidcisuser;

    @Temporal(TemporalType.DATE)
    private Date datefrom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ddate;

    private Integer didcisuser;

    @Temporal(TemporalType.DATE)
    private Date grantedfrom;

    @Temporal(TemporalType.DATE)
    private Date grantedto;

    private Integer idorgunit;

    private Integer idorgunituziv;

    private Integer idperson;

    @Column(name="idperson_original")
    private Integer idpersonOriginal;

    private Integer idpobytucel;

    private String note;

    private String pkp;

    private String refnumber;

    private Integer rstatus;

    @Temporal(TemporalType.DATE)
    private Date terminationdate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date udate;

    private Integer uidcisuser;

    private String visaapplicationnumber;

    public Tdustay() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getArrivaldate() {
        return this.arrivaldate;
    }

    public void setArrivaldate(Date arrivaldate) {
        this.arrivaldate = arrivaldate;
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

    public Date getGrantedfrom() {
        return this.grantedfrom;
    }

    public void setGrantedfrom(Date grantedfrom) {
        this.grantedfrom = grantedfrom;
    }

    public Date getGrantedto() {
        return this.grantedto;
    }

    public void setGrantedto(Date grantedto) {
        this.grantedto = grantedto;
    }

    public Integer getIdorgunit() {
        return this.idorgunit;
    }

    public void setIdorgunit(Integer idorgunit) {
        this.idorgunit = idorgunit;
    }

    public Integer getIdorgunituziv() {
        return this.idorgunituziv;
    }

    public void setIdorgunituziv(Integer idorgunituziv) {
        this.idorgunituziv = idorgunituziv;
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

    public Integer getIdpobytucel() {
        return this.idpobytucel;
    }

    public void setIdpobytucel(Integer idpobytucel) {
        this.idpobytucel = idpobytucel;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPkp() {
        return this.pkp;
    }

    public void setPkp(String pkp) {
        this.pkp = pkp;
    }

    public String getRefnumber() {
        return this.refnumber;
    }

    public void setRefnumber(String refnumber) {
        this.refnumber = refnumber;
    }

    public Integer getRstatus() {
        return this.rstatus;
    }

    public void setRstatus(Integer rstatus) {
        this.rstatus = rstatus;
    }

    public Date getTerminationdate() {
        return this.terminationdate;
    }

    public void setTerminationdate(Date terminationdate) {
        this.terminationdate = terminationdate;
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

    public String getVisaapplicationnumber() {
        return this.visaapplicationnumber;
    }

    public void setVisaapplicationnumber(String visaapplicationnumber) {
        this.visaapplicationnumber = visaapplicationnumber;
    }

}
