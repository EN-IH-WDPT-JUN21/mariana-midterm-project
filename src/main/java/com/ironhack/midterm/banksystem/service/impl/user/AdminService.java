package com.ironhack.midterm.banksystem.service.impl.user;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dao.user.User;
import com.ironhack.midterm.banksystem.dto.account.AccountDTO;
import com.ironhack.midterm.banksystem.dto.receipts.AccountCreationReceiptDTO;
import com.ironhack.midterm.banksystem.dto.receipts.UserCreationReceiptDTO;
import com.ironhack.midterm.banksystem.dto.requests.AccountCreationRequestDTO;
import com.ironhack.midterm.banksystem.dto.requests.UserCreationRequestDTO;
import com.ironhack.midterm.banksystem.enums.Result;
import com.ironhack.midterm.banksystem.enums.Status;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.UserAlreadyExistsException;
import com.ironhack.midterm.banksystem.exceptions.UserHasMultipleAccountsException;
import com.ironhack.midterm.banksystem.repository.account.AccountRepository;
import com.ironhack.midterm.banksystem.repository.operations.TransactionRepository;
import com.ironhack.midterm.banksystem.repository.user.UserRepository;
import com.ironhack.midterm.banksystem.service.interfaces.user.IAdminService;
import com.ironhack.midterm.banksystem.validators.LogicValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogicValidator logicValidator;

    @Autowired
    TransactionRepository transactionRepository;


    //Returns a list of all the Transactions
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    //Receives an account id | Returns an account
    public AccountDTO accessAccountDetails(Long accountId) throws AccountDoesNotExistException {

        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()){
            AccountDTO account = new AccountDTO();
            account.setId(optionalAccount.get().getId());
            account.setBalance(optionalAccount.get().getBalance());
            account.setUser(optionalAccount.get().getAccountHolder());
            return account;
        }else {
            throw new AccountDoesNotExistException("Account does not exist.");
        }

    }

    //Receives an account id and the amount to add to the account balance
    //Updates the account balance
    public void modifyBalance(Long accountId, BigDecimal amountDifference) throws AccountDoesNotExistException {

        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            optionalAccount.get().setBalance( optionalAccount.get().getBalance().add(amountDifference));
            accountRepository.save(optionalAccount.get());
        }else{
            throw new AccountDoesNotExistException("Account does not exist.");
        }

    }

    //Receives an account creation request
    //Creates and saves the account
    //Returns the account creation receipt
    public AccountCreationReceiptDTO storeAccount(AccountCreationRequestDTO accountCreationRequestDTO) throws UserHasMultipleAccountsException {

        //Checks if user already has an account
        if (logicValidator.accountHolderHasAnAccount(accountCreationRequestDTO.getAccountHolder())){
            throw new UserHasMultipleAccountsException("User can only have one account.");
        }

        //Creates the Receipt
        AccountCreationReceiptDTO accountCreationReceiptDTO = new AccountCreationReceiptDTO();
        accountCreationReceiptDTO.setAccountHolder(accountCreationReceiptDTO.getAccountHolder());
        accountCreationReceiptDTO.setBalance(accountCreationRequestDTO.getBalance());
        accountCreationReceiptDTO.setDate(LocalDateTime.now());

        //Creates and saves Account
        Account account = logicValidator.createsAccount(accountCreationRequestDTO);

        //Fills Result & Account Id in the Receipt
        accountCreationReceiptDTO.setResult(Result.OK);
        accountCreationReceiptDTO.setAccountId(account.getId());

        //Returns the account created
        return accountCreationReceiptDTO;
    }

    //Receives an user creation request
    //Creates and saves the user
    //Returns the user creation receipt
    public UserCreationReceiptDTO storeUser(UserCreationRequestDTO userCreationRequestDTO) throws UserAlreadyExistsException {

        //Checks if User already exists
        if (logicValidator.userExists(userCreationRequestDTO)){
            throw new UserAlreadyExistsException("There is already a User with that name");
        }

        //Creates the Receipt
        UserCreationReceiptDTO userCreationReceiptDTO = new UserCreationReceiptDTO();
        userCreationReceiptDTO.setName(userCreationRequestDTO.getName());
        userCreationReceiptDTO.setDate(LocalDateTime.now());

        //Creates and saves User
        User user = logicValidator.createsUser(userCreationRequestDTO);

        //Fills Result & Account Id in the Receipt
        userCreationReceiptDTO.setResult(Result.OK);
        userCreationReceiptDTO.setUserId(user.getId());

        //Returns user creation receipt
        return userCreationReceiptDTO;

    }

    //Receives account id and status
    //Changes the status on the account
    //Returns respective boolean
    public Account changeStatus(Long id, Status status) throws AccountDoesNotExistException {

        //Stores optional account
        Optional<Account> optionalAccount = accountRepository.findById(id);

        //Checks if account exists
        if (optionalAccount.isPresent()) {
            optionalAccount.get().setStatus(status);
        }else{
            throw new AccountDoesNotExistException("Account does not exist.");
        }

        //Returns account
        return accountRepository.save(optionalAccount.get());

    }
}
