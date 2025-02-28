package dio.restifull.service.impl;

import dio.restifull.model.User;
import dio.restifull.repository.UserRepository;
import dio.restifull.service.UserService;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository; 
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccount_Number(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("The User ID already exists");
        }
        return userRepository.save(userToCreate);
    }

    
  }
