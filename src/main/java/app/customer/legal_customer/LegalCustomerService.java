package app.customer.legal_customer;

import java.util.List;

public interface LegalCustomerService {

    List<LegalCustomer> listAllLegalCustomers();

    LegalCustomer addLegalCustomer(LegalCustomer customer);
}
