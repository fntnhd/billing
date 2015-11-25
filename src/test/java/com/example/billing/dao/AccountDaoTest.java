package com.example.billing.dao;

import com.example.billing.entity.Account;
import com.example.billing.entity.BillingPlan;
import com.example.billing.entity.BillingRate;
import com.example.billing.exception.ValidationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;

/**
 * Ensures that PhoneNumberValidator works correctly.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class AccountDaoTest {

    private BillingPlan billingPlan = null;

    @Autowired
    private AccountDao accountDao;

    @Before
    public void setupBillingPlan() {
        billingPlan = new BillingPlan();
        billingPlan.setName("Anytime Minutes");
        billingPlan.setBillingRate(new BillingRate("0.10"));
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
    public void createAccount() throws ValidationException {
        Account account = accountDao.createAccount("206-555-1212", billingPlan);

        assertEquals("206-555-1212", account.getPhoneNumber());
        assertEquals(new BigDecimal("0.10"), account.getBillingPlan().getBillingRate());
    }

    @Test
    public void createDuplicateAccount() {
        try {
            accountDao.createAccount("206-555-1212", billingPlan);
            accountDao.createAccount("206-555-1212", billingPlan);
            fail("Duplicate account creation was allowed.");
        }
        catch(ValidationException ve) {
            assertEquals("Account already exists for phone number: 206-555-1212", ve.getMessage());
        }
    }

    @Test
    public void findAccountByPhoneNumber() throws ValidationException {
        accountDao.createAccount("206-555-1212", billingPlan);
        accountDao.createAccount("703-555-1212", billingPlan);
        accountDao.createAccount("425-555-1212", billingPlan);

        Account account = accountDao.findAccountByPhoneNumber("703-555-1212");

        assertEquals("703-555-1212", account.getPhoneNumber());
    }

    @Test
    public void findAll() throws ValidationException {
        accountDao.createAccount("206-555-1212", billingPlan);
        accountDao.createAccount("703-555-1212", billingPlan);
        accountDao.createAccount("425-555-1212", billingPlan);
        accountDao.createAccount("423-555-1212", billingPlan);

        Collection<Account> accountList = accountDao.findAll();

        assertEquals(4, accountList.size());
    }

    @Test
    public void normalizePhoneNumber() throws ValidationException {
        Account account = accountDao.createAccount("7025551212", billingPlan);

        assertEquals("702-555-1212", account.getPhoneNumber());
    }

}
