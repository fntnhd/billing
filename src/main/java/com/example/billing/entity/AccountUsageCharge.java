package com.example.billing.entity;

import java.math.BigDecimal;

/**
 * Created by MrSteveAndrews on 11/11/15.
 */
public class AccountUsageCharge {

    private AccountUsage accountUsage;
    private BigDecimal charge;

    public AccountUsage getAccountUsage() {
        return accountUsage;
    }

    public void setAccountUsage(AccountUsage accountUsage) {
        this.accountUsage = accountUsage;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }
}
