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
    private int id;

    @Transient private Object data;

    @Lob private byte[] binData;

    private int idevidence;

    public Image() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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

    public int getIdevidence() {
        return this.idevidence;
    }

    public void setIdevidence(int idevidence) {
        this.idevidence = idevidence;
    }

}