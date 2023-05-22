package ma.emsi.digital_banking_backend.services;

import ma.emsi.digital_banking_backend.dtos.*;
import ma.emsi.digital_banking_backend.entities.BankAccount;
import ma.emsi.digital_banking_backend.entities.Customer;
import ma.emsi.digital_banking_backend.exceptions.BalanceNotSufficientException;
import ma.emsi.digital_banking_backend.exceptions.BankAccountNotFoundException;
import ma.emsi.digital_banking_backend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void transfer(String accountIdSource, double amount, String accountIdDestination) throws BankAccountNotFoundException, BalanceNotSufficientException;
    List<BankAccountDTO> bankAccountList();
    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
    //  CustomerDTO getEmail(String customerEmail);
   // List<CustomerDTO> getName(String name);

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);
    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
}
