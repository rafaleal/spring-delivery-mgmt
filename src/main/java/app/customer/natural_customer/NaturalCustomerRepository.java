package app.customer.natural_customer;

import app.enums.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NaturalCustomerRepository extends JpaRepository<NaturalCustomer, Long> {

    List<NaturalCustomer> findAllByStatusCode(StatusCode statusCode);


}
