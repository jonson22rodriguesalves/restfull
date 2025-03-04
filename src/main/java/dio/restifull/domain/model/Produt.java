package dio.restifull.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name = "tb_produt") // Adicionado o nome da tabela
public class Produt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do produto não pode estar em branco")
    @Size(min = 3, max = 255, message = "Nome do produto deve ter entre 3 e 255 caracteres")
    private String nome;

    @Size(max = 1000, message = "Descrição do produto não pode ter mais de 1000 caracteres")
    private String descricao;

    @NotNull(message = "Preço do produto não pode ser nulo")
    private double preco;

    // Construtores, getters e setters

    public Produt() {
    }

    public Produt(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}