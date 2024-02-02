package gustavo.material.MaterialDeConstrucao.model;

import gustavo.material.MaterialDeConstrucao.DAO.ClienteDao;
import gustavo.material.MaterialDeConstrucao.DAO.PedidoDao;
import gustavo.material.MaterialDeConstrucao.DAO.MaterialDao;
import gustavo.material.MaterialDeConstrucao.DAO.UsuarioDao;
import gustavo.material.MaterialDeConstrucao.Util.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class MaterialDeConstrucao {
	EntityManager em = JPAUtil.getEntityManager();
	MaterialDao materialDao = new MaterialDao(em);
	PedidoDao financeiroDao = new PedidoDao(em);
	ClienteDao clienteDao = new ClienteDao(em);
	UsuarioDao usuarioDao = new UsuarioDao(em);
	public void adicionaMaterial(Material mat){
		em.getTransaction().begin();
		materialDao.cadastrarProduto(mat);
		em.getTransaction().commit();
		em.clear();
	}
	public void cadastraCliente(Cliente cliente){
		em.getTransaction().begin();
		clienteDao.cadastroDeCliente(cliente);
		em.getTransaction().commit();
		em.close();
	}
	public void cadastraUsuario(Usuario usuario){
		em.getTransaction().begin();
		usuarioDao.cadastroDeUsuario(usuario);
		em.getTransaction().commit();
		em.clear();
	}
	public boolean verificaUsuario(String nome){
		List<Usuario> listaDeUsuarios = usuarioDao.buscaPorNome(nome);
		listaDeUsuarios.forEach(p-> System.out.println(p.getLogin()));
        return !listaDeUsuarios.isEmpty();
	}
	public boolean verificaSenha(String senha, String usuario){
		List<Usuario> listaDeSenhas = usuarioDao.ValidacaoDeSenhaCriteria(senha, usuario);
		listaDeSenhas.forEach(p -> System.out.println(p.getSenha()+p.getLogin()));
        return !listaDeSenhas.isEmpty();
	}
	public boolean verificaCliente(String nome){
		List<Cliente> listaDeCliente = clienteDao.validacaoCliente(nome);
		listaDeCliente.forEach(c-> System.out.println(c.getNome()));
        return !listaDeCliente.isEmpty();
	}
	public String listaDeMateriaisEmEstoque(){
		String retorno = "";
		List<Material> listaDeEstoque = materialDao.buscarEstoque();
		for (Material material :listaDeEstoque){

			retorno += "Codigo: "+material.getCodigo()+" | Descrição: "+material.getDescricao()+" | Preço: "+material.getPreco()+" | QtdMaterial: "+material.getQtdMaterial()+"\n";
		}
		return retorno;
	}
	public void adicionaNoEstoque(Long id, int qtdProduto){
		Material material = materialDao.buscarPorId(id);
		int qtdBuscada = material.getQtdMaterial();
		int totalParaEnviar = qtdBuscada + qtdProduto;
		Material materialAdicionar = new Material(material.codigo,material.getDescricao(),material.getPreco(),totalParaEnviar);
		em.getTransaction().begin();
		materialDao.atualizar(materialAdicionar);
		em.getTransaction().commit();
		em.clear();
	}
	public String estoqueGeral(){
		String retorno ="";
		List<Material> listaDeMaterial = materialDao.buscarTodos();
		for (Material material : listaDeMaterial){
			retorno += "Codigo: "+material.getCodigo()+" | Descrição: "+material.getDescricao()+" | Preço: "+material.getPreco()+" | QtdMaterial: "+material.getQtdMaterial()+" | Data de Entrada: "+material.getDataEntrada()+"\n";
		}
		return retorno;
	}
	public boolean validaCodigoProdt(Long id){
		List<Material> listaDeCodigos = materialDao.buscarPorIdValida(id);
        return !listaDeCodigos.isEmpty();

	}


}
