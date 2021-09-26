package com.ironhack.midterm.banksystem.validators;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.account.CheckingAccount;
import com.ironhack.midterm.banksystem.dao.account.SavingsAccount;
import com.ironhack.midterm.banksystem.dao.account.StudentCheckingAccount;
import com.ironhack.midterm.banksystem.dao.user.AccountHolder;
import com.ironhack.midterm.banksystem.dao.user.Admin;
import com.ironhack.midterm.banksystem.dao.user.User;
import com.ironhack.midterm.banksystem.dto.requests.AccountCreationRequestDTO;
import com.ironhack.midterm.banksystem.dto.requests.TransactionRequestDTO;
import com.ironhack.midterm.banksystem.dto.requests.UserCreationRequestDTO;
import com.ironhack.midterm.banksystem.enums.AccountType;
import com.ironhack.midterm.banksystem.enums.UserType;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;
import com.ironhack.midterm.banksystem.repository.account.AccountRepository;
import com.ironhack.midterm.banksystem.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Component
public class LogicValidatorService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;


    public boolean accountHolderHasAnAccount(AccountHolder accountHolder){
      return accountHolder.getAccount() != null ? true : false;

        }

    //Receives a transaction request
    //Validates if they exist and are not the same
    //Returns an array of both accounts
    public Optional<Account>[] validatesTransactionAccounts(TransactionRequestDTO transactionRequestDTO) throws AccountDoesNotExistException, EqualAccountsException {

        //Stores the accounts in their own objects, if they exist
        Optional<Account> optionalFromAccount = accountRepository.findById(transactionRequestDTO.getFromAccountId());
        Optional<Account> optionalToAccount = accountRepository.findById(transactionRequestDTO.getToAccountId());

        //Checks if they are different and if they exist in the database
        if (optionalFromAccount.get().equals(optionalToAccount.get())){
            throw new EqualAccountsException("The account that initiated the transaction is the same that is receiving the transaction.");
        }else if (optionalFromAccount.isEmpty()) {
            throw new AccountDoesNotExistException("The account that initiated the transaction does not exist.");
        }else if (optionalToAccount.isEmpty()){
            throw new AccountDoesNotExistException("The account that is receiving the transaction does not exist.");
        }

        //Returns an array of both acounts
        return new Optional[]{optionalFromAccount, optionalToAccount};

    }

    //Receives a birth date
    //Returns the current age
    public int calculateAgeFromDoB(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    //Receives account creation request
    //Creates and stores account
    //Returns saved account
    public Account createsAccount(AccountCreationRequestDTO accountCreationRequestDTO) {

        Account account;

        //Creates account
        if(accountCreationRequestDTO.getAccountType() == AccountType.SAVINGS){
            account = new SavingsAccount();
        } else if (accountCreationRequestDTO.getAccountType() == AccountType.CHECKING
                && calculateAgeFromDoB(accountCreationRequestDTO.getAccountHolder().getDateOfBirth()) < 24){
            account = new StudentCheckingAccount();
        } else {
            account = new CheckingAccount();
        }

        //Fills balance and account holder
        account.setBalance(accountCreationRequestDTO.getBalance());
        account.setAccountHolder(accountCreationRequestDTO.getAccountHolder());

        //Saves Account
        accountRepository.save(account);

        //Returns account
        return account;

    }

    //Receives user creation request
    //Checks if there is another user with the same name
    //Returns respective boolean
    public boolean userExists(UserCreationRequestDTO userCreationRequestDTO){

        Optional<User> optionalUser = Optional.ofNullable(userRepository.findUserByName(userCreationRequestDTO.getName()));

        return optionalUser.isPresent() ? true : false;

    }

    //Receives user id
    //Checks if there is another user with the same id
    //Returns respective boolean
    public boolean userExists(Long id){

        Optional<User> optionalUser = Optional.ofNullable(userRepository.findUserById(id));

        return optionalUser.isPresent() ? true : false;

    }

    //Reveives user creation request
    //Creates and saves user
    //Returns saves user
    public User createsUser(UserCreationRequestDTO userCreationRequestDTO) {

        User user;

        //Creates user
        if(userCreationRequestDTO.getUserType() == UserType.ADMIN){
            user = new Admin();
        } else {
           user = new AccountHolder();
           ((AccountHolder) user).setDateOfBirth(userCreationRequestDTO.getDateOfBirth());
        }

        //Fills user name
        user.setName(userCreationRequestDTO.getName());

        //Saves user
        userRepository.save(user);

        //Returns user
        return user;

    }

}




