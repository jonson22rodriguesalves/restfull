package dio.restifull.domain.repository;

import dio.restifull.domain.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    // Métodos personalizados, se necessário
}
