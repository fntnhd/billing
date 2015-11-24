package com.example.billing.dao;

import com.example.billing.entity.Account;
import com.example.billing.entity.BillingPlan;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by MrSteveAndrews on 11/23/15.
 */
@Repository
public interface AccountDao {

    /**
     * Creates a new account
     *
     * @param phoneNumber
     * @param billingPlan
     * @return Account
     * @see BillingPlan
     */
    public Account createAccount(String phoneNumber, BillingPlan billingPlan);

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
    void deleteAll();

    /**
     * Returns all accounts in the system.
     *
     * @return
     */
    Collection<Account> findAll();
}
