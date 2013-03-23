package cz.zcu.jet.cis2.db.en.blob;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * The persistent class for the cisblobpool database table.
 */
@Entity
public class Photo implements Serializable {

  private static final long serialVersionUID = -888447339618899883L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idblobpool")
  private int id;

  @Column(name = "idevidence")
  private int idEvidence;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(name = "obraz")
  private byte[] image;


  public Integer getId() {
    return this.id;
  }


  public void setId(final Integer idblobpool) {
    this.id = idblobpool;
  }


  public Integer getIdEvidence() {
    return this.idEvidence;
  }


  public void setIdEvidence(final Integer idevidence) {
    this.idEvidence = idevidence;
  }


  public byte[] getImage() {
    return this.image;
  }


  public void setImage(final byte[] obraz) {
    this.image = obraz;
  }

}
