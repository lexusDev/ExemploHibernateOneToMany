package onetomany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author mello
 */
@Entity
public class Pessoa implements Serializable{
    
    @Id
    private long cpf;
    private String nome;
    
    @OneToOne
    private Endereco endereco;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Telefone> telefones = new ArrayList<>();

    public Pessoa() {
    }
    
    public Pessoa(long cpf, String nome, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Pessoa(long cpf, String nome, Endereco endereco, List<Telefone> telefones) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefones = telefones;
    }

    
    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
    
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", telefones=" + telefones + '}';
    }

}
