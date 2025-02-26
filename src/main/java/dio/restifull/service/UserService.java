package dio.restifull.service;

import dio.restifull.model.User;




public interface UserService {

    User findById(long id);

    User create(User userToCreate);
    
}
