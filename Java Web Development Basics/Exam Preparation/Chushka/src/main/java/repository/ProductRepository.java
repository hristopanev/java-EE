package repository;

import domain.entites.Product;

import java.util.List;

public interface ProductRepository {

    Product save(Product product);

    Product findById(String id);

    List<Product> findAll();

    Product edit(Product product);

    void delete(String id);
}
