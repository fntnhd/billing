package com.matisia.billing.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;

/**
 * Ensures billing plan service works correctly.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class BillingPlanServiceTest {

    @Autowired
    private BillingPlanService billingPlanService;

    @Test
    public void serviceInjection() {
        assertNotNull(billingPlanService);
    }

}
