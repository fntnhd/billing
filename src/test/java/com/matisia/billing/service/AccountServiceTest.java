package com.matisia.billing.service;

import com.matisia.billing.entity.Account;
import com.matisia.billing.entity.BillingPlan;
import com.matisia.billing.entity.BillingRate;
import com.matisia.billing.exception.ValidationException;
import junit.framework.TestCase;
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
import static junit.framework.TestCase.fail;

/**`
 * Ensures that AccountService is working correctly
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    private BillingPlan defaultBillingPlan;

    @Before
    public void setupBillingPlan() {
        defaultBillingPlan = newBillingPlan("Anytime Minutes", "0.10");
    }

    @After
    public void deleteAllAccounts() {
        accountService.deleteAll();

        assertEquals(0, accountService.findAll().size());
    }

    @Test
    public void accountServiceInjection() {
        assertNotNull(accountService);
    }

    @Test
    public void createAccount() throws ValidationException {
        Account account = newAccount("206-555-1212", defaultBillingPlan);
        accountService.createAccount(account);

        account = accountService.findAccountByPhoneNumber("206-555-1212");

        assertEquals("206-555-1212", account.getPhoneNumber());
        TestCase.assertEquals(new BillingRate("0.10"), account.getBillingPlan().getBillingRate());
    }

    @Test
    public void updateAccount() throws ValidationException {
        Account account = newAccount("206-555-1212", defaultBillingPlan);
        accountService.createAccount(account);
        BillingPlan billingPlan = newBillingPlan("Super Saver Plan", ".08");

        account = accountService.findAccountByPhoneNumber("206-555-1212");
        account.setBillingPlan(billingPlan);
        accountService.updateAccount(account);
        account = accountService.findAccountByPhoneNumber("206-555-1212");

        assertEquals("206-555-1212", account.getPhoneNumber());
        assertEquals(new BillingRate("0.08"), account.getBillingPlan().getBillingRate());
    }

    @Test
    public void createDuplicateAccount() {
        try {
            Account account = newAccount("206-555-1212", defaultBillingPlan);
            accountService.createAccount(account);
            account = newAccount("206-555-1212", defaultBillingPlan);
            accountService.createAccount(account);
            fail("Duplicate account creation allowed.");
        }
        catch(ValidationException ve) {
            assertEquals("Account already exists for phone number: 206-555-1212", ve.getMessage());
        }
    }

    @Test
    public void updateNonExistentAccount() {
        try {
            Account account = newAccount("206-555-1212", defaultBillingPlan);
            accountService.updateAccount(account);
            fail("Update of non-existent account allowed.");
        }
        catch(ValidationException ve) {
            assertEquals("Account does not exist for phone number: 206-555-1212", ve.getMessage());
        }
    }

    @Test
    public void findAccountByPhoneNumber() throws ValidationException {
        Account account = newAccount("206-555-1212", defaultBillingPlan);
        accountService.createAccount(account);
        account = newAccount("703-555-1212", defaultBillingPlan);
        accountService.createAccount(account);
        account = newAccount("425-555-1212", defaultBillingPlan);
        accountService.createAccount(account);

        account = accountService.findAccountByPhoneNumber("703-555-1212");

        assertEquals("703-555-1212", account.getPhoneNumber());
    }

    @Test
    public void findAll() throws ValidationException {
        Account account = newAccount("206-555-1212", defaultBillingPlan);
        accountService.createAccount(account);
        account = newAccount("703-555-1212", defaultBillingPlan);
        accountService.createAccount(account);
        account = newAccount("425-555-1212", defaultBillingPlan);
        accountService.createAccount(account);
        account = newAccount("423-555-1212", defaultBillingPlan);
        accountService.createAccount(account);

        Collection<Account> accountList = accountService.findAll();

        assertEquals(4, accountList.size());
    }

    @Test
    public void normalizePhoneNumber() throws ValidationException {
        Account account = newAccount("702-555-1212", defaultBillingPlan);
        accountService.createAccount(account);

        assertEquals("702-555-1212", account.getPhoneNumber());
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
