package gustavo.material.MaterialDeConstrucao.DAO;

import gustavo.material.MaterialDeConstrucao.model.Pedidos;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoDao {
    private EntityManager em;
    public PedidoDao(EntityManager em){
        this.em = em;
    }
    public void cadastrarPedido(Pedidos pedido){
        em.persist(pedido);
    }
    public List<Pedidos> listaDePedidos(){
        String jpql = "SELECT p FROM Pedidos p ";
        return em.createQuery(jpql, Pedidos.class).getResultList();
    }





















}
