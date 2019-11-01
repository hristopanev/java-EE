package domain.models.binding;

import domain.entites.Type;

import java.math.BigDecimal;

public class ProductCreateBindingModel {

    private String name;
    private BigDecimal price;
    private String description;
    private Type type;

    public ProductCreateBindingModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
