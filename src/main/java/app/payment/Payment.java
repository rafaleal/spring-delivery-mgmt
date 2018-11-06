package app.payment;

import app.delivery.Delivery;
import app.enums.PaymentStatus;
import app.enums.PaymentType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Rafael Leal on 14/10/2018.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private BigDecimal amount;

    @Temporal(TemporalType.DATE)
    private Date payedOn;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_TYPE")
    private PaymentType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_STAT")
    private PaymentStatus status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPayedOn() {
        return payedOn;
    }

    public void setPayedOn(Date payedOn) {
        this.payedOn = payedOn;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }
}
