package app.delivery;

import app.biker.Biker;
import app.customer.Customer;
import app.enums.DeliveryStatus;
import app.enums.StatusCode;
import app.payment.Payment;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Rafael Leal on 12/10/2018.
 */
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "STAT_DELIVERY")
    private DeliveryStatus statusDelivery;

    @Column(name = "REGISTERED_TIME")
    @CreationTimestamp
    private Date registeredTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROUTE_ID", foreignKey = @ForeignKey(name = "ROUTE_ID_FK"))
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", foreignKey = @ForeignKey(name = "CUSTOMER_ID_FK"))
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BIKER_ID", foreignKey = @ForeignKey(name = "BIKER_ID_FK"))
    private Biker biker;

    @Enumerated(EnumType.STRING)
    @Column(name = "STAT_CD")
    private StatusCode statusCode;

    @OneToOne(
            mappedBy = "delivery",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Payment payment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeliveryStatus getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(DeliveryStatus statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public Date getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Biker getBiker() {
        return biker;
    }

    public void setBiker(Biker biker) {
        this.biker = biker;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
