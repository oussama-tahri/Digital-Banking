package ma.emsi.digital_banking_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.digital_banking_backend.enums.OperationType;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AccountOperation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private double amount;
    @Enumerated(EnumType.STRING)
    private OperationType type;
    private String description;
    @ManyToOne
    private BankAccount bankAccount;
}
