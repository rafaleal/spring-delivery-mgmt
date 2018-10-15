package app.customer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Rafael Leal on 12/10/2018.
 */
@Entity
@DiscriminatorValue("LEGAL")
public class LegalCustomer extends Customer{

    private String socialReason;

    private String fantasyName;

    private String cnpj;

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
