package ma.emsi.digital_banking_backend.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.digital_banking_backend.entities.AccountOperation;
import ma.emsi.digital_banking_backend.entities.BankAccount;
import ma.emsi.digital_banking_backend.entities.Customer;
import ma.emsi.digital_banking_backend.enums.AccountStatus;

import java.util.Date;
import java.util.List;


@Data
public class SavingBankAccountDTO extends BankAccountDTO {

    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
}
