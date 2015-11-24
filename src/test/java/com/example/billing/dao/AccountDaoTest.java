package com.example.billing.dao;

import com.example.billing.entity.Account;
import com.example.billing.entity.BillingPlan;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by MrSteveAndrews on 11/23/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class AccountDaoTest {

    @After
    public void deleteAllAccounts() {
        accountDao.deleteAll();

        assertEquals(0, accountDao.findAll().size());
    }

    @Autowired
    private AccountDao accountDao;

    @Test
    public void testAccountDaoInjection() {
        assertNotNull(accountDao);
    }

    @Test
    public void testCreateAccount() {
        BillingPlan billingPlan = billingPlan("0.10");

        Account account = accountDao.createAccount("206-555-1212", billingPlan);

        assertEquals("206-555-1212", account.getPhoneNumber());
        assertEquals(new BigDecimal("0.10"), account.getBillingPlan().getBillingRate());
    }

    @Test
    public void testFindAccountByPhoneNumber() {
        BillingPlan billingPlan = billingPlan("0.10");

        accountDao.createAccount("206-555-1212", billingPlan);
        accountDao.createAccount("703-555-1212", billingPlan);
        accountDao.createAccount("425-555-1212", billingPlan);

        Account account = accountDao.findAccountByPhoneNumber("703-555-1212");

        assertEquals("703-555-1212", account.getPhoneNumber());
    }

    private BillingPlan billingPlan(String rate) {
        BillingPlan billingPlan = new BillingPlan();
        billingPlan.setBillingRate(new BigDecimal(rate));

        return billingPlan;
    }
}
