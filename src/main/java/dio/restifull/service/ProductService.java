package dio.restifull.service;

import dio.restifull.domain.model.Product;

public interface ProductService {

    Product findById(Long id);

    Product create(Product productToCreate);

    Product update(Long id, Product productToUpdate);

    boolean delete(Long id);
}