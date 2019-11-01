package domain.models.service;

import java.time.LocalDateTime;

public class OrderServiceModel {

    private ProductServiceModel productServiceModel;
    private UserServiceModel userServiceModel;
    private LocalDateTime orderedOn;

    public OrderServiceModel() {
    }

    public ProductServiceModel getProductServiceModel() {
        return this.productServiceModel;
    }

    public void setProductServiceModel(ProductServiceModel productServiceModel) {
        this.productServiceModel = productServiceModel;
    }

    public UserServiceModel getUserServiceModel() {
        return this.userServiceModel;
    }

    public void setUserServiceModel(UserServiceModel userServiceModel) {
        this.userServiceModel = userServiceModel;
    }

    public LocalDateTime getOrderedOn() {
        return this.orderedOn;
    }

    public void setOrderedOn(LocalDateTime orderedOn) {
        this.orderedOn = orderedOn;
    }
}
