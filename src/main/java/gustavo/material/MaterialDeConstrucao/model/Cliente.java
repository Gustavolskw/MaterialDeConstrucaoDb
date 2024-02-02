package gustavo.material.MaterialDeConstrucao.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    public Cliente(String nome){
        this.nome = nome;
    }
    public Cliente(){

    }
}
