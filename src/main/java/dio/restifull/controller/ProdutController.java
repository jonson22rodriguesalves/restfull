package dio.restifull.controller;

import dio.restifull.domain.model.Produt;
import dio.restifull.domain.repository.ProdutRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/produts")
public class ProdutController {

    @Autowired
    private ProdutRepository produtRepository;

    @GetMapping
    public List<Produt> listarProduts() {
        return produtRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Produt> criarProdut(@Valid @RequestBody Produt produt) {
        Produt novoProduto = produtRepository.save(produt);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @GetMapping("/{id}")
    public Produt buscarProdut(@PathVariable Long id) {
        return produtRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produt não encontrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produt> atualizarProdut(@PathVariable Long id, @Valid @RequestBody Produt produtAtualizado) {
        if (!produtRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produt não encontrado");
        }
        produtAtualizado.setId(id);
        Produt produtAtualizadoSalvo = produtRepository.save(produtAtualizado);

        return ResponseEntity.ok(produtAtualizadoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdut(@PathVariable Long id) {
        if (!produtRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        produtRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}