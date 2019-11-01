package web.beans;

import domain.models.service.ProductServiceModel;
import service.ProductService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ProductDetails {

    private ProductService productService;

    public ProductDetails() {
    }

    @Inject
    public ProductDetails(ProductService productService) {
        this.productService = productService;
    }

    public ProductServiceModel getProduct(String id) {
        return this.productService.getById(id);
    }
}
