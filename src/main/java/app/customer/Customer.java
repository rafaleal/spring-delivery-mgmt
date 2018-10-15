package app.customer;

import app.details.Address;
import app.details.Email;
import app.details.Phone;
import app.enums.ContractType;
import app.enums.StatusCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Rafael Leal on 12/10/2018.
 */
@Entity(name = "CUSTOMER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CUSTOMER_TYPE",
    discriminatorType = DiscriminatorType.STRING)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private Address address;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Phone> phones;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Email> emails;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONTRACT_TYPE")
    private ContractType contractType;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "STAT_CD")
    private StatusCode statusCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
