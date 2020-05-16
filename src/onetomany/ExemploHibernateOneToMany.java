package onetomany;


import onetomany.model.*;
import onetomany.infra.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author mello
 */
public class ExemploHibernateOneToMany {

    public static void main(String[] args) {
        Endereco end = new Endereco("Rua das Margaridas", 10);

        Telefone t1 = new Telefone(15, 192898392);
        Telefone t2 = new Telefone(10, 192898346);
        List<Telefone> listaTelefones = new ArrayList<>();
        listaTelefones.add(t1);
        listaTelefones.add(t2);

        Pessoa pessoa = new Pessoa(123456780, "Maria", end, listaTelefones);

        // salva a pessoa no banco
        PessoaDAO pdao = new PessoaDAO();
        pdao.salvar(pessoa);

        
        // Recupera uma pessoa do banco dado um CPF
        Pessoa pessoaByCPF = pdao.recuperaByCPF(123456780L);
        System.out.println("CPF:\t" + pessoaByCPF.getCpf());
        System.out.println("Nome:\t" +pessoaByCPF.getNome() );
        System.out.println(pessoaByCPF.getEndereco() );
        System.out.println(pessoaByCPF.getTelefones());
    }
}
