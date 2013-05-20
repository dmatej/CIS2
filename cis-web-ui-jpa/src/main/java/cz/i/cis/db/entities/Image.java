package cz.i.cis.db.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.io.*;


/**
 * The persistent class for the image database table.
 *
 */
@Entity
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient private Object data;

    @Lob private byte[] binData;

    private Integer idevidence;

    public Image() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getData() {
        try {
            return this.data !=null ? this.data : (this.data = new ObjectInputStream(new ByteArrayInputStream(this.binData)).readObject());
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public void setData(Object data) {
        this.data = data;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            final ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(data);
            oos.close();
            this.binData = baos.toByteArray();
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    public Integer getIdevidence() {
        return this.idevidence;
    }

    public void setIdevidence(Integer idevidence) {
        this.idevidence = idevidence;
    }

}