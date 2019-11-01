package web.beans;

import domain.entites.Type;
import domain.models.binding.ProductCreateBindingModel;
import domain.models.service.OrderServiceModel;
import domain.models.service.ProductServiceModel;
import domain.models.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import service.ProductService;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class ProductCreateBean extends BaseBean {

    private ProductCreateBindingModel productCreateBindingModel;
    private OrderServiceModel orderServiceModel;

    private ProductService productService;
    private UserService userService;
    private ModelMapper modelMapper;

    public ProductCreateBean() {
    }

    @Inject
    public ProductCreateBean(ProductService productService, UserService userService, ModelMapper modelMapper) {
        this.productService = productService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.productCreateBindingModel = new ProductCreateBindingModel();
    }

    public ProductCreateBindingModel getProductCreateBindingModel() {
        return this.productCreateBindingModel;
    }

    public void setProductCreateBindingModel(ProductCreateBindingModel productCreateBindingModel) {
        this.productCreateBindingModel = productCreateBindingModel;
        this.orderServiceModel = new OrderServiceModel();
    }

    public void createProduct() {
        String username = (String) ((HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false)).getAttribute("username");

        ProductServiceModel productServiceModel = this.modelMapper
                .map(this.productCreateBindingModel, ProductServiceModel.class);

        UserServiceModel userServiceModel = this.modelMapper
                .map(this.userService.findUserByUsername(username), UserServiceModel.class);

        this.orderServiceModel.setOrderedOn(LocalDateTime.now());
        this.orderServiceModel.setProductServiceModel(productServiceModel);
        this.orderServiceModel.setUserServiceModel(userServiceModel);

        this.productService.createProduct(productServiceModel);
    }
}
