package app.delivery;

import app.biker.Biker;
import app.customer.Customer;
import app.enums.DeliveryStatus;
import app.enums.StatusCode;
import app.payment.Payment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Rafael Leal on 12/10/2018.
 */
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "STAT_DELIVERY", nullable = false)
    @ColumnDefault("'REGISTERED'")
    private DeliveryStatus statusDelivery;

    @CreationTimestamp
    private LocalTime registeredTime;

    private LocalTime collectUpTime;

    private LocalTime handoverTime;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "CREATED_AT", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "UPDATED_AT", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ROUTE_ID", foreignKey = @ForeignKey(name = "ROUTE_ID_FK"), nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", foreignKey = @ForeignKey(name = "CUSTOMER_ID_FK"), nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "BIKER_ID", foreignKey = @ForeignKey(name = "BIKER_ID_FK"), nullable = false)
    private Biker biker;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = "STAT_CD", nullable = false)
    @ColumnDefault("'A'")
    private StatusCode statusCode;

    @OneToOne(cascade = CascadeType.PERSIST)
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

    public LocalTime getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(LocalTime registeredTime) {
        this.registeredTime = registeredTime;
    }

    public LocalTime getCollectUpTime() {
        return collectUpTime;
    }

    public void setCollectUpTime(LocalTime collectUpTime) {
        this.collectUpTime = collectUpTime;
    }

    public LocalTime getHandoverTime() {
        return handoverTime;
    }

    public void setHandoverTime(LocalTime handoverTime) {
        this.handoverTime = handoverTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
