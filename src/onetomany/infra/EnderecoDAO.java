package onetomany.infra;


import onetomany.model.Endereco;
import javax.persistence.EntityManager;

public class EnderecoDAO {
    
     public void salvar(Endereco endereco) {

        //cria um gerenciador de entidades
        EntityManager em = ConnectionFactoryHibernate.getEntityManager();

        try {
            //abrir uma transacao
            em.getTransaction().begin();
            //solicita ao gerenciador que salve a entidade
            em.persist(endereco);
            //fechar a transacao
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //encerra o gerenciador de entidades
            em.close();
        }
    }
    
}
