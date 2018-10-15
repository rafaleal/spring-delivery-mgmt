package app.delivery;

import app.details.Address;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rafael Leal on 12/10/2018.
 */
@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long waitingTime;

    @Temporal(TemporalType.DATE)
    private Date arrivalTime;

    @OneToOne
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Long waitingTime) {
        this.waitingTime = waitingTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
