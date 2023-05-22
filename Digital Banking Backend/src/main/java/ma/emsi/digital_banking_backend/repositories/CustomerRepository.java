package ma.emsi.digital_banking_backend.repositories;

import ma.emsi.digital_banking_backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    List<Customer> findByName(String name);
}
