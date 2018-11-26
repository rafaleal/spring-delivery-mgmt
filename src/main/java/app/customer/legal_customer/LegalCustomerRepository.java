package app.customer.legal_customer;

import app.enums.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegalCustomerRepository extends JpaRepository<LegalCustomer, Long> {

    List<LegalCustomer> findAllByStatusCode(StatusCode statusCode);
}
