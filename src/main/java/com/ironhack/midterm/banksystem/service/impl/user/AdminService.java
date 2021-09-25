package com.ironhack.midterm.banksystem.service.impl.user;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.user.User;
import com.ironhack.midterm.banksystem.dto.account.AccountDTO;
import com.ironhack.midterm.banksystem.dto.receipts.AccountCreationReceiptDTO;
import com.ironhack.midterm.banksystem.dto.receipts.UserCreationReceiptDTO;
import com.ironhack.midterm.banksystem.dto.requests.AccountCreationRequestDTO;
import com.ironhack.midterm.banksystem.dto.requests.UserCreationRequestDTO;
import com.ironhack.midterm.banksystem.enums.Result;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.UserAlreadyExists;
import com.ironhack.midterm.banksystem.exceptions.UserHasMultipleAccounts;
import com.ironhack.midterm.banksystem.repository.account.AccountRepository;
import com.ironhack.midterm.banksystem.repository.user.UserRepository;
import com.ironhack.midterm.banksystem.service.interfaces.user.IAdminService;
import com.ironhack.midterm.banksystem.validators.LogicValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogicValidatorService logicValidatorService;



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

    //Falta verificar se o saldo da conta fica negativo e/ou se é possível ter saldo negativo
    public void modifyBalance(Long accountId, BigDecimal amountDifference) throws AccountDoesNotExistException {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            optionalAccount.get().setBalance( optionalAccount.get().getBalance().add(amountDifference));
            accountRepository.save(optionalAccount.get());
        }else{
            throw new AccountDoesNotExistException("Account does not exist.");
        }

    }

    public Account storeAccount(AccountCreationRequestDTO accountCreationRequestDTO) throws UserHasMultipleAccounts {

        //Checks if User already has an Account
        if (logicValidatorService.accountHolderHasAnAccount(accountCreationRequestDTO.getAccountHolder())){
            throw new UserHasMultipleAccounts("User can only have one account.");
        }


        //Creates the Receipt
        AccountCreationReceiptDTO accountCreationReceiptDTO = new AccountCreationReceiptDTO();
        accountCreationReceiptDTO.setAccountHolder(accountCreationReceiptDTO.getAccountHolder());
        accountCreationReceiptDTO.setBalance(accountCreationRequestDTO.getBalance());

        //Creates Account
        Account account = logicValidatorService.createsAccount(accountCreationRequestDTO);

        //Saves Account
        accountRepository.save(account);

        //Fills Result & Account Id in the Receipt
        accountCreationReceiptDTO.setResult(Result.OK);
        accountCreationReceiptDTO.setAccountId(account.getId());

        return account;
    }

    public User storeUser(UserCreationRequestDTO userCreationRequestDTO) throws UserAlreadyExists {

        //Checks if User already exists
        if (logicValidatorService.userExists(userCreationRequestDTO)){
            throw new UserAlreadyExists("There is already a User with that name");
        }

        //Creates the Receipt
        UserCreationReceiptDTO userCreationReceiptDTO = new UserCreationReceiptDTO();
        userCreationReceiptDTO.setName(userCreationRequestDTO.getName());

        //Creates User
        User user = logicValidatorService.createsUser(userCreationRequestDTO);

        //Saves User
        userRepository.save(user);

        //Fills Result & Account Id in the Receipt
        userCreationReceiptDTO.setResult(Result.OK);
        userCreationReceiptDTO.setUserId(user.getId());

        return user;
    }



}
