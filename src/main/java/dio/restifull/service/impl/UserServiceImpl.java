package dio.restifull.service.impl;

import dio.restifull.domain.model.*;
import dio.restifull.domain.repository.*;
import dio.restifull.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;
    private final FeatureRepository featureRepository;
    private final NewsRepository newsRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository, CardRepository cardRepository, FeatureRepository featureRepository, NewsRepository newsRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
        this.featureRepository = featureRepository;
        this.newsRepository = newsRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public User update(Long id, User userToUpdate) {
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            // Validar IDs dos objetos relacionados
            validateRelatedObjectIds(userToUpdate);

            // Atualizar os dados do usuário
            userToUpdate.setId(existingUser.getId());
            return userRepository.save(userToUpdate);
        } else {
            throw new NoSuchElementException("User not found with id: " + id);
        }
    }

    @Override
    public boolean delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private void validateRelatedObjectIds(User user) {
        if (accountRepository.findById(user.getAccount().getId()).isEmpty()) {
            throw new NoSuchElementException("Account not found");
        }
        if (cardRepository.findById(user.getCard().getId()).isEmpty()) {
            throw new NoSuchElementException("Card not found");
        }
        if (user.getFeatures() != null) {
            for (Feature feature : user.getFeatures()) {
                if (featureRepository.findById(feature.getId()).isEmpty()) {
                    throw new NoSuchElementException("Feature not found");
                }
            }
        }
        if (user.getNews() != null) {
            for (News news : user.getNews()) {
                if (newsRepository.findById(news.getId()).isEmpty()) {
                    throw new NoSuchElementException("News not found");
                }
            }
        }
    }
}