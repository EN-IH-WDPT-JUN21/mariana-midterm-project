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


    public Optional<Account>[] validatesTransactionAccounts(TransactionRequestDTO transactionRequestDTO) throws AccountDoesNotExistException, EqualAccountsException {

        Optional<Account> optionalFromAccount = accountRepository.findById(transactionRequestDTO.getFromAccountId());
        Optional<Account> optionalToAccount = accountRepository.findById(transactionRequestDTO.getToAccountId());

        if (optionalFromAccount.get().equals(optionalToAccount.get())){
            throw new EqualAccountsException("The account that initiated the transaction is the same that is receiving the transaction.");
        }else if (optionalFromAccount.isEmpty()) {
            throw new AccountDoesNotExistException("The account that initiated the transaction does not exist.");
        }else if (optionalToAccount.isEmpty()){
            throw new AccountDoesNotExistException("The account that is receiving the transaction does not exist.");
        }

        return new Optional[]{optionalFromAccount, optionalToAccount};
    }

    public boolean accountHolderHasAnAccount(AccountHolder accountHolder){
      return accountHolder.getAccount() != null ? true : false;

        }


    public int calculateAgeFromDoB(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public Account createsAccount(AccountCreationRequestDTO accountCreationRequestDTO) {
        Account account;

        if(accountCreationRequestDTO.getAccountType() == AccountType.SAVINGS){

            account = new SavingsAccount();

        }else if (accountCreationRequestDTO.getAccountType() == AccountType.CHECKING
                && calculateAgeFromDoB(accountCreationRequestDTO.getAccountHolder().getDateOfBirth()) < 24){
            account = new StudentCheckingAccount();
        }else {
            account = new CheckingAccount();
        }
        account.setBalance(accountCreationRequestDTO.getBalance());
        account.setAccountHolder(accountCreationRequestDTO.getAccountHolder());
        return account;
    }


    public boolean userExists(UserCreationRequestDTO userCreationRequestDTO){

        Optional<User> optionalUser = Optional.ofNullable(userRepository.findUserByName(userCreationRequestDTO.getName()));

       return optionalUser.isPresent() ? true : false;
    }

    public User createsUser(UserCreationRequestDTO userCreationRequestDTO) {

        User user;

        if(userCreationRequestDTO.getUserType() == UserType.ADMIN){

            user = new Admin();
        }else {
           user = new AccountHolder();
           ((AccountHolder) user).setDateOfBirth(userCreationRequestDTO.getDateOfBirth());
        }

        user.setName(userCreationRequestDTO.getName());
        return user;
    }

}




