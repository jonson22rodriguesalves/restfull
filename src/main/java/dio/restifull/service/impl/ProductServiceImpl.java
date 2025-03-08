package dio.restifull.service.impl;

import dio.restifull.domain.model.Product;
import dio.restifull.domain.repository.ProductRepository;
import dio.restifull.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Product create(Product productToCreate) {
        return productRepository.save(productToCreate);
    }

    @Override
    public Product update(Long id, Product productToUpdate) {
        Optional<Product> existingProductOptional = productRepository.findById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            productToUpdate.setId(existingProduct.getId());
            return productRepository.save(productToUpdate);
        } else {
            throw new NoSuchElementException("Product not found with id: " + id);
        }
    }

    @Override
    public boolean delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}