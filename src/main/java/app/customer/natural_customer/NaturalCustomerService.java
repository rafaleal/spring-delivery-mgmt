package app.customer.natural_customer;

import java.util.List;

public interface NaturalCustomerService {
    List<NaturalCustomer> listAllNaturalCustomres();

    NaturalCustomer addNaturalCustomer(NaturalCustomer customer);
}
