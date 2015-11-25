package com.example.billing.service;

import com.example.billing.entity.Account;
import com.example.billing.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Responsible for managing accounts
 */
@Service
public interface AccountService {

    /**
     * Create an account
     * @param account The account to create
     * @return
     */
    public Account createAccount(Account account) throws ValidationException;

    /**
     * Update an account
     * @param account The account to update
     * @return
     */
    public Account updateAccount(Account account) throws ValidationException;

    /**
     * Answers all the accounts in the system.
     * @return
     */
    public Collection<Account> findAll();

    /**
     * Returns an account for the specified phone number
     *
     * @param phoneNumber
     * @return Account
     */
    public Account findAccountByPhoneNumber(String phoneNumber);

    /**
     * Deletes all accounts in the system.
     */
    public void deleteAll();
}
