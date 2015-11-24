package com.example.billing.data;

import com.example.billing.entity.Account;
import com.example.billing.entity.AccountUsageCharge;
import com.example.billing.entity.BillingPeriod;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Storage for billing entities
 *
 *
 * Created by MrSteveAndrews on 11/11/15.
 */
@Repository
public interface BillingDao {

    public List<AccountUsageCharge> getChargesForAccountForBillingPeriod(Account account, BillingPeriod billingPeriod);

}
