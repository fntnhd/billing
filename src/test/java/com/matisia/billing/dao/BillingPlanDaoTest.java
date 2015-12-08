package com.matisia.billing.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;

/**
 * Validates that billing plan DAO works correctly
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class BillingPlanDaoTest {

    @Autowired
    private BillingPlanDao billingPlanDao;

    @Test
    public void daoInjection() {
        assertNotNull(billingPlanDao);
    }
}
