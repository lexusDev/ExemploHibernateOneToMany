package onetomany.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String rua;
    private int numero;
    

    public Endereco() {
    }

    public Endereco(String rua, int numero) {
        this.rua = rua;
        this.numero = numero;
    }
    
    
    public Long getId() {
        return id;
    }
    
    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

     public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua + ", numero=" + numero + '}';
    }

    

   
    
    
    
}
