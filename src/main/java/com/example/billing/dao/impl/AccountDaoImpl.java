package com.example.billing.dao.impl;

import com.example.billing.dao.AccountDao;
import com.example.billing.entity.Account;
import com.example.billing.entity.BillingPlan;
import com.example.billing.exception.ValidationException;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Responsible for saving and finding accounts.
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    private static Map<String, Account> ACCOUNTS;

    static {
        ACCOUNTS = new HashMap<String, Account>();
    }

    /**
     * Creates a new account
     *
     * @param phoneNumber
     * @param billingPlan
     * @return Account
     * @see BillingPlan
     */
    public synchronized Account createAccount(String phoneNumber, BillingPlan billingPlan) throws ValidationException {
        Account account = new Account();
        account.setPhoneNumber(phoneNumber);
        account.setBillingPlan(billingPlan);
        account.validate();

        if(ACCOUNTS.get(account.getPhoneNumber()) != null) {
            throw new ValidationException("Account already exists for phone number: " + account.getPhoneNumber());
        }

        ACCOUNTS.put(phoneNumber, account);

        return account;
    }

    /**
     * Returns an account for the specified phone number
     *
     * @param phoneNumber
     * @return Account
     */
    public Account findAccountByPhoneNumber(String phoneNumber) {
        return ACCOUNTS.get(phoneNumber);
    }

    /**
     * Deletes all accounts in the system.
     */
    public void deleteAll() {
        ACCOUNTS = new HashMap<String, Account>();
    }

    /**
     * Returns all accounts in the system.
     *
     * @return
     */
    public Collection<Account> findAll() {
        return ACCOUNTS.values();
    }

}
