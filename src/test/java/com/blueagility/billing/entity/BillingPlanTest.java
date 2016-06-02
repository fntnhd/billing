package com.blueagility.billing.entity;

import com.blueagility.billing.exception.ValidationException;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Ensures billing plans work correctly
 */
public class BillingPlanTest {

    @Test
    public void validateNullName() {
        BillingPlan billingPlan = new BillingPlan();
        try {
            billingPlan.validate();
            fail("Expected name is null validation exception");
        }
        catch(ValidationException ve) {
            assertEquals("Name is null", ve.getMessage());
        }
    }

    @Test
    public void validateNullBillingRate() {
        BillingPlan billingPlan = new BillingPlan();
        billingPlan.setName("Billing Plan Name");
        try {
            billingPlan.validate();
            fail("Expected billing rate is null validation exception");
        }
        catch (ValidationException ve) {
            assertEquals("Billing rate is null", ve.getMessage());
        }
    }

    @Test
    public void validateNoErrors() {
        BillingPlan billingPlan = new BillingPlan();
        billingPlan.setName("Billing Plan Name");
        billingPlan.setBillingRate(new BillingRate("0.10"));
        try {
            billingPlan.validate();
        }
        catch (ValidationException ve) {
            fail("Expected no validation exception");
        }
    }

}
