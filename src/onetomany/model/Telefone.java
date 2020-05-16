package onetomany.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mello
 */
@Entity
public class Telefone implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int ddd;
    private long numero;

    public Telefone() {
    }

    public Telefone(int ddd, long numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public Telefone(long id, int ddd, long numero) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
    }

    
    
    public long getId() {
        return id;
    }

    public int getDdd() {
        return ddd;
    }

    public long getNumero() {
        return numero;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefone {" + "id=" + id + ", ddd=" + ddd + ", numero=" + numero + '}';
    }
    
    
    
}
