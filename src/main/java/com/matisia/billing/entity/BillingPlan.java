package com.matisia.billing.entity;

import com.matisia.billing.exception.ValidationException;

import java.math.BigDecimal;

/**
 * A billing plan specifies the rate a customer will be charged for usage.
 *
 */
public class BillingPlan {

    private String name;
    private BillingRate billingRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BillingRate getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(BillingRate billingRate) {
        this.billingRate = billingRate;
    }

    public void validate() throws ValidationException {
        if(name == null) {
            throw new ValidationException("Name is null");
        }

        if(billingRate == null) {
            throw new ValidationException("Billing rate is null");
        }
    }
}
