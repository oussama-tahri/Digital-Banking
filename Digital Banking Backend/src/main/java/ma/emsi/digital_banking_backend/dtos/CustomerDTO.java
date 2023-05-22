package ma.emsi.digital_banking_backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.digital_banking_backend.entities.BankAccount;

import java.util.List;


@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
}
