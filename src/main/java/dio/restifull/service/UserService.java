package dio.restifull.service;

import dio.restifull.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

    User update(Long id, User userToUpdate); // Correção: User maiúsculo

    boolean delete(Long id);
}