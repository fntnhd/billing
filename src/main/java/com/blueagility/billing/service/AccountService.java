package com.blueagility.billing.service;

import com.blueagility.billing.entity.Account;
import com.blueagility.billing.exception.ValidationException;
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
    Account createAccount(Account account) throws ValidationException;

    /**
     * Update an account
     * @param account The account to update
     * @return
     */
    Account updateAccount(Account account) throws ValidationException;

    /**
     * Answers all the accounts in the system.
     * @return
     */
    Collection<Account> findAll();

    /**
     * Returns an account for the specified phone number
     *
     * @param phoneNumber
     * @return Account
     */
    Account findAccountByPhoneNumber(String phoneNumber);

    /**
     * Deletes all accounts in the system.
     */
    void deleteAll();
}
