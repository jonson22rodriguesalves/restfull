package dio.restifull.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity(name = "tb_product")
public class Product extends BaseItem {

    @NotBlank(message = "Nome do produto não pode estar em branco")
    @Size(min = 3, max = 255, message = "Nome do produto deve ter entre 3 e 255 caracteres")
    private String nome;

    @NotNull(message = "Preço do produto não pode ser nulo")
    private double preco;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}