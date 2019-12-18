package panda.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "receipts")
public class Receipt extends BaseEntity {

    private BigDecimal fee;
    private LocalDateTime issueOn;
    private User recipient;
    private Package aPackage;

    public Receipt() {
    }

    @Column(name = "fee", nullable = false)
    public BigDecimal getFee() {
        return this.fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Column(name = "issue_on", nullable = false)
    public LocalDateTime getIssueOn() {
        return this.issueOn;
    }

    public void setIssueOn(LocalDateTime issueOn) {
        this.issueOn = issueOn;
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
