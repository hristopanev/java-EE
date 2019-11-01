package web.beans;

import domain.models.service.ProductServiceModel;
import service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ProductListBean {

    private List<ProductServiceModel> productServiceModels;

    private ProductService productService;

    public ProductListBean() {
    }

    @Inject
    public ProductListBean(ProductService productService) {
        this.productService = productService;
    }


    @PostConstruct
    public void init() {
        setProductServiceModels(this.productService.getAllProducts());
    }

    public List<ProductServiceModel> getProductServiceModels() {
        return this.productServiceModels;
    }

    public void setProductServiceModels(List<ProductServiceModel> productServiceModels) {
        this.productServiceModels = productServiceModels;
    }

}
