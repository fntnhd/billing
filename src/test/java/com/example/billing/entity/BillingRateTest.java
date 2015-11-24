package com.example.billing.entity;

import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by MrSteveAndrews on 11/11/15.
 */
public class BillingRateTest {

    @Test
    public void billingRateMultiplication() {
        BillingRate billingRate = new BillingRate("0.33");
        BigDecimal product = billingRate.multiply(new BigDecimal(3));
        assertEquals("0.99", product.toString());
    }

    @Test
    public void billingRateAddition() {
        BillingRate billingRate = new BillingRate("0.33");
        BigDecimal product = billingRate.add(new BigDecimal("0.25"));
        assertEquals("0.58", product.toString());
    }
}
