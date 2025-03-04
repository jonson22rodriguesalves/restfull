package dio.restifull.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity(name = "tb_produt")
public class Produt extends BaseItem {

    @NotBlank(message = "Nome do produto não pode estar em branco")
    @Size(min = 3, max = 255, message = "Nome do produto deve ter entre 3 e 255 caracteres")
    private String nome;

    @NotNull(message = "Preço do produto não pode ser nulo")
    private double preco;

    @ManyToMany
    private List<User> users; // Alterado para ManyToMany e List<User>

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}