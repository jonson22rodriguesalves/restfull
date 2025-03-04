package dio.restifull.service.impl;

import dio.restifull.domain.model.User;
import dio.restifull.domain.repository.UserRepository;
import dio.restifull.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
            throw new DuplicateAccountNumberException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    @Transactional
    public User update(Long id, User userToUpdate) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("User not found with ID: " + id);
        }

        User existingUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);

        String newAccountNumber = userToUpdate.getAccount().getNumber();
        String existingAccountNumber = existingUser.getAccount().getNumber();

        logger.info("Updating user with ID: {}, New Account Number: {}, Existing Account Number: {}", id, newAccountNumber, existingAccountNumber);

        if (!existingAccountNumber.equals(newAccountNumber)) {
            logger.info("Account number changed. Checking for duplicates.");
            if (userRepository.existsByAccount_Number(newAccountNumber)) {
                logger.warn("Duplicate Account Number found for user ID {}: {}", id, newAccountNumber);
                throw new DuplicateAccountNumberException("This Account number already exists.");
            }
        }

        userToUpdate.setId(existingUser.getId());
        return userRepository.save(userToUpdate);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }

    public static class DuplicateAccountNumberException extends IllegalArgumentException {
        public DuplicateAccountNumberException(String message) {
            super(message);
        }
    }
}