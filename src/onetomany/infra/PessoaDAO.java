package onetomany.infra;

import onetomany.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mello
 */
public class PessoaDAO {

    public void salvar(Pessoa pessoa) {

        //cria um gerenciador de entidades
        EntityManager em = ConnectionFactoryHibernate.getEntityManager();

        try {
            //abrir uma transacao
            em.getTransaction().begin();
            //solicita ao gerenciador que salve a entidade

            EnderecoDAO edao = new EnderecoDAO();
            edao.salvar(pessoa.getEndereco());

            em.persist(pessoa);
            //fechar a transacao
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //encerra o gerenciador de entidades
            em.close();
        }
    }

    public Pessoa recuperaByCPF(long cpf) {
        Pessoa pessoa = new Pessoa();

        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();
            
            //solicita ao gerenciador todas a instância da classe Pessoa dado um cpf
            Query query = em.createQuery("from Pessoa p JOIN FETCH p.telefones where p.cpf = :cpf")
                    .setParameter("cpf", cpf);
            
            pessoa = (Pessoa) query.getSingleResult();
            
            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pessoa;
    }
}
