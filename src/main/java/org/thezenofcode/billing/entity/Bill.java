package org.thezenofcode.billing.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * A bill contains the total amount due for an account for a billing period
 *
 * Created by MrSteveAndrews on 11/11/15.
 */
public class Bill {

    private List<AccountUsageCharge> accountUsageChargeList;
    private BillingPeriod billingPeriod;
    private BigDecimal totalAmount;

    public List<AccountUsageCharge> getAccountUsageChargeList() {
        return accountUsageChargeList;
    }

    public void setAccountUsageChargeList(List<AccountUsageCharge> accountUsageChargeList) {
        this.accountUsageChargeList = accountUsageChargeList;
    }

    public BillingPeriod getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(BillingPeriod billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
