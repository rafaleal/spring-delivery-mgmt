package app.customer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Rafael Leal on 12/10/2018.
 */
@Entity
@DiscriminatorValue("NATURAL")
public class NaturalCustomer extends Customer{

    private String fullName;

    private String cpf;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
