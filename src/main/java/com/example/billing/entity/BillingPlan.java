package com.example.billing.entity;

import java.math.BigDecimal;

/**
 * A billing plan specifies the rate a customer will be charged for usage.
 *
 * Created by MrSteveAndrews on 11/8/15.
 */
public class BillingPlan {

    private String name;
    private BigDecimal billingRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(BigDecimal billingRate) {
        this.billingRate = billingRate;
    }
}
