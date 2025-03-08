package dio.restifull.domain.repository;

import dio.restifull.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    // Métodos personalizados, se necessário
}