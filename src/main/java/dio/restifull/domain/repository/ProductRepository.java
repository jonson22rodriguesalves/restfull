package dio.restifull.domain.repository;
import dio.restifull.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Adicione aqui métodos específicos se necessário, como findByName, etc.
}