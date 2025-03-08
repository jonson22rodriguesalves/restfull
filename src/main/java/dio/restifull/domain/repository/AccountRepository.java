package dio.restifull.domain.repository;

import dio.restifull.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Métodos personalizados, se necessário
}