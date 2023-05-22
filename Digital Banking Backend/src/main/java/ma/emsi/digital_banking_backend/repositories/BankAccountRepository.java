package ma.emsi.digital_banking_backend.repositories;

import ma.emsi.digital_banking_backend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
