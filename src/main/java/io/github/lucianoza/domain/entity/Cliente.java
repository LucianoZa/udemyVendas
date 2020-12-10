package io.github.lucianoza.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente") //ex: (name = "tb_cliente", schema = "vendas") Opcional se nome da tabela = nome da classe
public class Cliente {

    @Id //define chave primária. É obrigatória em uma entidade!
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="nome", length = 100)
    private String nome;

    @JsonIgnore //Serve para não mostrar Pedidos no retorno do cliente
    @OneToMany(mappedBy="cliente", fetch = FetchType.LAZY) //LAZY = não retornar todos pedidos
    private Set<Pedido> pedidos; //Poderia trocar Ser por List, Collection, etc.

    @Column (name = "cpf", length = 11)
    private String cpf;

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
