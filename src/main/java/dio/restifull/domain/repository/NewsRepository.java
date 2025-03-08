package dio.restifull.domain.repository;

import dio.restifull.domain.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    // Métodos personalizados, se necessário
}