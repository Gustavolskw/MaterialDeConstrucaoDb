package gustavo.material.MaterialDeConstrucao.DAO;

import gustavo.material.MaterialDeConstrucao.model.Material;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class MaterialDao {
    private EntityManager em;
    public  MaterialDao(EntityManager em){
        this.em = em;
    }

    public void cadastrarProduto(Material material){
        this.em.persist(material);
    }
    public void atualizar(Material material){
        this.em.merge(material);
    }
    public Material buscarPorId(Long id){
        return em.find(Material.class, id);
    }
    public List<Material> buscarEstoque(){
        String jpql = "SELECT p FROM Material p";
        return em.createQuery(jpql, Material.class).getResultList();
    }
    public List<Material> buscarTodos(){
        String jpql = "SELECT p FROM Material p";
        return em.createQuery(jpql, Material.class).getResultList();
    }
    public List<Material> buscarPorIdValida(Long id){
        String jpql = "SELECT p FROM Material p WHERE p.codigo = :id";
        return em.createQuery(jpql, Material.class).setParameter("id", id).getResultList();
    }






}
