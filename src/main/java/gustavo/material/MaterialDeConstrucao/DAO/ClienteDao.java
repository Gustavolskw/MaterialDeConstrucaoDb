package gustavo.material.MaterialDeConstrucao.DAO;

import gustavo.material.MaterialDeConstrucao.model.Cliente;
import gustavo.material.MaterialDeConstrucao.model.Usuario;
import org.w3c.dom.Entity;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {
    EntityManager em;
    public ClienteDao(EntityManager em){
        this.em = em;
    }
    public void cadastroDeCliente(Cliente cliente){
        em.persist(cliente);
    }
    public List<Cliente> validacaoCliente(String nome){
        String jpql = "SELECT c FROM Cliente c WHERE c.nome = :nome";

        return em.createQuery(jpql, Cliente.class).setParameter("nome", nome).getResultList();
    }


}
