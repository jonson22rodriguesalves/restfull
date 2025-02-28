package dio.restifull.service;

import dio.restifull.model.User;




public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
    
}
