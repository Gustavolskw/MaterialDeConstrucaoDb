package gustavo.material.MaterialDeConstrucao.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@Table(name = "materiais")
public class Material {
    @Id
    protected Long codigo;
    protected String descricao;
    protected BigDecimal preco;
    @Column(name = "qtd_material")
    protected int qtdMaterial;
    @Column(name = "data_de_entrada")
    LocalDate dataEntrada = LocalDate.now();
public Material(){

}
public Material(Long id, String descricao, BigDecimal preco, Integer qtdMaterial){
    this.codigo = id;
    this.descricao= descricao;
    this.preco = preco;
    this.qtdMaterial = qtdMaterial;
}

    public Material(Material mat) {
        this.codigo = mat.getCodigo();
        this.descricao = mat.getDescricao();
        this.preco = mat.getPreco();
        this.qtdMaterial = mat.getQtdMaterial();
        this.dataEntrada = LocalDate.now();
    }

}