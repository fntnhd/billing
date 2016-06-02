package com.blueagility.billing.dao;

import com.blueagility.billing.entity.BillingPlan;
import com.blueagility.billing.entity.BillingRate;
import com.blueagility.billing.exception.ValidationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;
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

    @Before
    public void before() {
        billingPlanDao.deleteAll();
    }

    @After
    public void after() {
        billingPlanDao.deleteAll();
    }

    @Test
    public void deleteBillingPlan() throws ValidationException {
        BillingPlan billingPlan = new BillingPlan();
        billingPlan.setName("Test");
        billingPlan.setBillingRate(new BillingRate("0.06"));
        billingPlanDao.save(billingPlan);

        assertEquals(1, billingPlanDao.findAll().size());

        billingPlan = billingPlanDao.delete(billingPlan);

        assertEquals("Test", billingPlan.getName());
        assertEquals(0, billingPlanDao.findAll().size());
    }
}
