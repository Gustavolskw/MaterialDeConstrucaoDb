package gustavo.material.MaterialDeConstrucao.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "compras")
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "qtd_compra")
	protected int quantidadeCompra;
	protected  String descricao;
	@Column(name = "valor_total")
	protected BigDecimal valorTotal;
	protected BigDecimal preco;
	@Column(name = "data_venda")
	LocalDate dataVenda = LocalDate.now();

public Pedidos(){

}
    Pedidos(Integer qtdCompra, String descricao, BigDecimal valorTotal, BigDecimal preco){
	this.quantidadeCompra = qtdCompra;
	this.descricao = descricao;
	this.valorTotal = valorTotal;
	this.preco = preco;
	}
}
