package com.matisia.billing.dao;

import com.matisia.billing.entity.BillingRate;
import com.matisia.billing.exception.ValidationException;
import com.matisia.billing.entity.Account;
import com.matisia.billing.entity.BillingPlan;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Ensures that PhoneNumberValidator works correctly.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class AccountDaoTest {

    private BillingPlan defaultBillingPlan = null;

    @Autowired
    private AccountDao accountDao;

    @Before
    public void setupBillingPlan() {
        defaultBillingPlan = newBillingPlan("Anytime Minutes", "0.10");
    }

    @After
    public void deleteAllAccounts() {
        accountDao.deleteAll();

        assertEquals(0, accountDao.findAll().size());
    }

    @Test
    public void accountDaoInjection() {
        assertNotNull(accountDao);
    }

    @Test
    public void saveNewAccount() {
        Account newAccount = new Account();
        newAccount.setPhoneNumber("206-555-1212");
        newAccount.setBillingPlan(defaultBillingPlan);

        accountDao.save(newAccount);
        Account savedAccount = accountDao.findAccountByPhoneNumber("206-555-1212");

        assertEquals("206-555-1212", savedAccount.getPhoneNumber());
        assertEquals(new BillingRate("0.10"), savedAccount.getBillingPlan().getBillingRate());
    }

    @Test
    public void saveUpdatedAccount() {
        Account newAccount = new Account();
        newAccount.setPhoneNumber("206-555-1212");
        newAccount.setBillingPlan(defaultBillingPlan);
        accountDao.save(newAccount);
        BillingPlan billingPlan = newBillingPlan("Super Saver Plan", ".08");

        Account account = accountDao.findAccountByPhoneNumber("206-555-1212");
        account.setBillingPlan(billingPlan);
        accountDao.save(account);
        Account savedAccount = accountDao.findAccountByPhoneNumber("206-555-1212");

        assertEquals("206-555-1212", savedAccount.getPhoneNumber());
        assertEquals(new BillingRate("0.08"), savedAccount.getBillingPlan().getBillingRate());
    }

    @Test
    public void findAccountByPhoneNumber() throws ValidationException {
        Account account = newAccount("206-555-1212", defaultBillingPlan);
        accountDao.save(account);
        account = newAccount("703-555-1212", defaultBillingPlan);
        accountDao.save(account);
        account = newAccount("425-555-1212", defaultBillingPlan);
        accountDao.save(account);

        account = accountDao.findAccountByPhoneNumber("703-555-1212");

        assertEquals("703-555-1212", account.getPhoneNumber());
    }

    @Test
    public void findAll() throws ValidationException {
        Account account = newAccount("206-555-1212", defaultBillingPlan);
        accountDao.save(account);
        account = newAccount("703-555-1212", defaultBillingPlan);
        accountDao.save(account);
        account = newAccount("425-555-1212", defaultBillingPlan);
        accountDao.save(account);
        account = newAccount("423-555-1212", defaultBillingPlan);
        accountDao.save(account);

        Collection<Account> accountList = accountDao.findAll();

        assertEquals(4, accountList.size());
    }

    private Account newAccount(String phoneNumber, BillingPlan billingPlan) {
        Account account = new Account();
        account.setPhoneNumber(phoneNumber);
        account.setBillingPlan(billingPlan);

        return account;
    }

    private BillingPlan newBillingPlan(String name, String rate) {
        BillingPlan billingPlan = new BillingPlan();
        billingPlan.setName(name);
        billingPlan.setBillingRate(new BillingRate(rate));

        return billingPlan;
    }

}
