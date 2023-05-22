package ma.emsi.digital_banking_backend;

import ma.emsi.digital_banking_backend.dtos.BankAccountDTO;
import ma.emsi.digital_banking_backend.dtos.CurrentBankAccountDTO;
import ma.emsi.digital_banking_backend.dtos.CustomerDTO;
import ma.emsi.digital_banking_backend.dtos.SavingBankAccountDTO;
import ma.emsi.digital_banking_backend.entities.*;
import ma.emsi.digital_banking_backend.enums.AccountStatus;
import ma.emsi.digital_banking_backend.enums.OperationType;
import ma.emsi.digital_banking_backend.exceptions.BalanceNotSufficientException;
import ma.emsi.digital_banking_backend.exceptions.BankAccountNotFoundException;
import ma.emsi.digital_banking_backend.exceptions.CustomerNotFoundException;
import ma.emsi.digital_banking_backend.repositories.AccountOperationRepository;
import ma.emsi.digital_banking_backend.repositories.BankAccountRepository;
import ma.emsi.digital_banking_backend.repositories.CustomerRepository;
import ma.emsi.digital_banking_backend.services.BankAccountService;
import ma.emsi.digital_banking_backend.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner consultationOfAccounts(BankAccountService bankAccountService) {
        return args -> {
            Stream.of("Oussama","Marouane","Mohammed","Nawfal","Hamza").forEach(name -> {
                CustomerDTO customer = new CustomerDTO();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                bankAccountService.saveCustomer(customer);
            });
            bankAccountService.listCustomers().forEach(customer -> {
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random()*100000,5420,customer.getId());
                    bankAccountService.saveSavingBankAccount(Math.random()*200000,7.5, customer.getId());
                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });
                    List<BankAccountDTO> bankAccounts = bankAccountService.bankAccountList();
                    for (BankAccountDTO bankAccountDTO: bankAccounts) {
                        for (int i = 0; i < 10; i++) {
                            String accountId;
                            if (bankAccountDTO instanceof SavingBankAccountDTO) {
                                accountId=((SavingBankAccountDTO) bankAccountDTO).getId();
                            }else {
                                accountId=((CurrentBankAccountDTO) bankAccountDTO).getId();
                            }
                            bankAccountService.credit(accountId,10000+Math.random()*150000,"Credit");
                            bankAccountService.debit(accountId,1000+Math.random()*9500,"Debit");
                        }
                    }
        };
    }
    //@Bean
    CommandLineRunner creationOfAccounts(BankAccountRepository bankAccountRepository,
                            CustomerRepository customerRepository,
                            AccountOperationRepository accountOperationRepository) {
        return args -> {
            Stream.of("Oussama", "Nawfal", "Marouane", "Mohammed").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(customer -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*7000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(customer);
                currentAccount.setOverDraft(7);
                bankAccountRepository.save(currentAccount);


                //***************************************************

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random()*7000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(customer);
                savingAccount.setInterestRate(2.5);
                bankAccountRepository.save(savingAccount);
            });

            bankAccountRepository.findAll().forEach(acc -> {

                for (int i=0; i<10; i++) {
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random() * 50);
                    accountOperation.setType(Math.random() > 0.5 ? OperationType.DEBIT : OperationType.CREDIT);
                    accountOperation.setBankAccount(acc);
                    accountOperationRepository.save(accountOperation);
                }
            });
        };
    }
}
