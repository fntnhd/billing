package devops.demo.billing.data.impl;

import devops.demo.billing.data.BillingDao;
import devops.demo.billing.entity.Account;
import devops.demo.billing.entity.AccountUsageCharge;
import devops.demo.billing.entity.BillingPeriod;
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
