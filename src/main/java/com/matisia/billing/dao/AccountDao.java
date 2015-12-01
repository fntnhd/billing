package com.matisia.billing.dao;

import com.matisia.billing.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by MrSteveAndrews on 11/23/15.
 */
@Repository
public interface AccountDao {

    /**
     * Creates a new account
     *
     * @param account
     * @return Account
     */
    public Account save(Account account);

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

    /**
     * Returns all accounts in the system.
     *
     * @return
     */
    Collection<Account> findAll();
}
