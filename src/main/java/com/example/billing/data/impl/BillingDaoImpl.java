package com.example.billing.data.impl;

import com.example.billing.data.BillingDao;
import com.example.billing.entity.Account;
import com.example.billing.entity.AccountUsageCharge;
import com.example.billing.entity.BillingPeriod;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MrSteveAndrews on 11/11/15.
 */
@Repository
public class BillingDaoImpl implements BillingDao {

    public BillingDaoImpl() {
        accountBillingPeriodUsageCharges = new HashMap<Account, Map<BillingPeriod, List<AccountUsageCharge>>>();
    }

    private Map<Account, Map<BillingPeriod, List<AccountUsageCharge>>> accountBillingPeriodUsageCharges;

    public List<AccountUsageCharge> getChargesForAccountForBillingPeriod(Account account, BillingPeriod billingPeriod) {
        Map<BillingPeriod, List<AccountUsageCharge>> billingPeriodUsageCharges = accountBillingPeriodUsageCharges.get(account);
        return (billingPeriodUsageCharges != null) ? billingPeriodUsageCharges.get(billingPeriod) : null;
    }
}
