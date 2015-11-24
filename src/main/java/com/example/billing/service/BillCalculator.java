package com.example.billing.service;


import com.example.billing.data.BillingDao;
import com.example.billing.entity.Account;
import com.example.billing.entity.AccountUsageCharge;
import com.example.billing.entity.Bill;
import com.example.billing.entity.BillingPeriod;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Computes a customer's bill based on usage
 *
 * Created by MrSteveAndrews on 11/8/15.
 */
@Component
public class BillCalculator {

    @Resource
    BillingDao billingDao;

    public Bill calculateBill(Account account, BillingPeriod billingPeriod) {

        BigDecimal billingRate = account.getBillingPlan().getBillingRate();
        List<AccountUsageCharge> accountUsageChargeList = billingDao.getChargesForAccountForBillingPeriod(account, billingPeriod);

return null;
    }

}
