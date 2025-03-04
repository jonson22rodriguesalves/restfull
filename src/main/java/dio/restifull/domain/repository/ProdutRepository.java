package dio.restifull.domain.repository;

import dio.restifull.domain.model.Produt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutRepository extends JpaRepository<Produt, Long> {
}