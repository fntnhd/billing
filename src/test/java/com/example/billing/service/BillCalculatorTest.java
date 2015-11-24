package com.example.billing.service;

import com.example.billing.entity.Account;
import com.example.billing.entity.BillingPeriod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by MrSteveAndrews on 11/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class BillCalculatorTest {

    @Autowired
    private BillCalculator billCalculator;

    @Test
    public void validateBillCalculatorNotNull() {
        assertNotNull(billCalculator.billingDao);
    }

    @Test
    public void validateNullUsagesForNewAccountAndNewBillingPeriod() {
        assertNull(billCalculator.billingDao.getChargesForAccountForBillingPeriod(new Account(), new BillingPeriod()));
    }

}
