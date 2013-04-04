package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the code_state database table.
 * 
 */
@Entity
@Table(name="code_state")
public class CodeState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String code;

	@Column(name="code_icao")
	private String codeIcao;

	@Column(name="code_iso")
	private String codeIso;

	private int idstate;

	private String name;

	@Column(name="name_cz")
	private String nameCz;

	@Column(name="name_en")
	private String nameEn;

	@Column(name="name_full")
	private String nameFull;

	@Column(name="name_nativ")
	private String nameNativ;

	@Column(name="name_upper")
	private String nameUpper;

	private String note;

	private short rank;

	@Temporal(TemporalType.DATE)
	private Date validfrom;

	@Temporal(TemporalType.DATE)
	private Date validto;

	public CodeState() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeIcao() {
		return this.codeIcao;
	}

	public void setCodeIcao(String codeIcao) {
		this.codeIcao = codeIcao;
	}

	public String getCodeIso() {
		return this.codeIso;
	}

	public void setCodeIso(String codeIso) {
		this.codeIso = codeIso;
	}

	public int getIdstate() {
		return this.idstate;
	}

	public void setIdstate(int idstate) {
		this.idstate = idstate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameCz() {
		return this.nameCz;
	}

	public void setNameCz(String nameCz) {
		this.nameCz = nameCz;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameFull() {
		return this.nameFull;
	}

	public void setNameFull(String nameFull) {
		this.nameFull = nameFull;
	}

	public String getNameNativ() {
		return this.nameNativ;
	}

	public void setNameNativ(String nameNativ) {
		this.nameNativ = nameNativ;
	}

	public String getNameUpper() {
		return this.nameUpper;
	}

	public void setNameUpper(String nameUpper) {
		this.nameUpper = nameUpper;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public short getRank() {
		return this.rank;
	}

	public void setRank(short rank) {
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