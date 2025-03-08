package dio.restifull.controller;

import dio.restifull.domain.model.User;
import dio.restifull.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.HashMap;
import java.util.Map;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User userToUpdate) {
        // Verificar se o usuário com o ID fornecido existe
        if (userService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        // Verificar se os IDs dos objetos relacionados estão presentes
        if (!areRelatedObjectIdsPresent(userToUpdate)) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Todos os IDs dos objetos relacionados devem ser fornecidos.");
            return ResponseEntity.badRequest().body(error);
        }

        var userUpdated = userService.update(id, userToUpdate);
        return ResponseEntity.ok(userUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (userService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private boolean areRelatedObjectIdsPresent(User user) {
        if (user.getAccount() == null || user.getAccount().getId() == null) {
            return false;
        }
        if (user.getCard() == null || user.getCard().getId() == null) {
            return false;
        }
        if (user.getFeatures() != null) {
            for (var feature : user.getFeatures()) {
                if (feature.getId() == null) {
                    return false;
                }
            }
        }
        if (user.getNews() != null) {
            for (var news : user.getNews()) {
                if (news.getId() == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
