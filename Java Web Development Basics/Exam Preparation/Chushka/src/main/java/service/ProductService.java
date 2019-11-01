package service;

import domain.models.service.ProductServiceModel;

import java.util.List;

public interface ProductService {

    void createProduct(ProductServiceModel productServiceModel);

    ProductServiceModel getById(String id);

    List<ProductServiceModel> getAllProducts();

    boolean editProduct(ProductServiceModel productServiceModel);

    void deleteProduct(String id);
}
