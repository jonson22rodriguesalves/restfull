package dio.restifull.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode estar em branco")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String name;

    @Valid
    @NotNull(message = "Conta não pode ser nula")
    @OneToOne(cascade = CascadeType.MERGE)
    private Account account;

    @Valid
    @NotNull(message = "Cartão não pode ser nulo")
    @OneToOne(cascade = CascadeType.MERGE)
    private Card card;

    @Valid
    @NotNull(message = "Lista de features não pode ser nula")
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Feature> features;

    @Valid
    @NotNull(message = "Lista de notícias não pode ser nula")
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<News> news;

    @ManyToMany(mappedBy = "users") // Alterado para ManyToMany
    private List<Produt> produtos;

    // ... (outros métodos)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Produt> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produt> produtos) {
        this.produtos = produtos;
    }
}