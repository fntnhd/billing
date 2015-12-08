package com.matisia.billing.dao.impl;

import com.matisia.billing.dao.AccountDao;
import com.matisia.billing.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Responsible for saving and finding accounts.
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    private static Map<String, Account> ACCOUNTS = null;

    static {
        ACCOUNTS = new HashMap<String, Account>();
    }

    /**
     * Creates a new account
     *
     * @param account
     * @return Account
     */
    public Account save(Account account) {
        ACCOUNTS.put(account.getPhoneNumber(), account);

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
