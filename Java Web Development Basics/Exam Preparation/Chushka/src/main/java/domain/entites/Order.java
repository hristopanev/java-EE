package domain.entites;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private Product product;
    private User client;
    private LocalDateTime orderedOn;

    public Order() {
    }

    @OneToOne(targetEntity = Product.class)
    @JoinColumn(
            name = "product_id", referencedColumnName = "id"
    )
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @OneToOne(targetEntity = User.class)
    @JoinColumn(
            name = "user_id", referencedColumnName = "id"
    )
    public User getClient() {
        return this.client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Column(name = "order_on")
    public LocalDateTime getOrderedOn() {
        return this.orderedOn;
    }

    public void setOrderedOn(LocalDateTime orderedOn) {
        this.orderedOn = orderedOn;
    }
}
