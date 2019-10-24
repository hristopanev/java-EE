package domain.models.binding;

import domain.entites.Status;
import domain.models.service.UserServiceModel;

import java.time.LocalDateTime;

public class PackageCreateBindingModel {

    private String description;
    private Double weight;
    private String shippingAddress;
    private Status status;
    private String recipient;

    public PackageCreateBindingModel() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public String getRecipient() {
        return this.recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
