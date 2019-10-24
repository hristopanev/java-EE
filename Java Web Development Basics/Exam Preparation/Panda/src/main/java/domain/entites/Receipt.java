package domain.entites;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "receipt")
public class Receipt extends BaseEntity {

    private Double fee;
    private LocalDateTime issuedOn;
    private User recipient;
    private Package aPackage;

    public Receipt() {
    }

    @Column(name = "fee", nullable = false)
    public Double getFee() {
        return this.fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    @Column(name = "issue_on")
    public LocalDateTime getIssuedOn() {
        return this.issuedOn;
    }

    public void setIssuedOn(LocalDateTime issuedOn) {
        this.issuedOn = issuedOn;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(
            name = "recipient_id",
            referencedColumnName = "id"
    )
    public User getRecipient() {
        return this.recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    @OneToOne(targetEntity = Package.class)
    @JoinColumn(
            name = "package_id",
            referencedColumnName = "id"
    )
    public Package getaPackage() {
        return this.aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }
}
