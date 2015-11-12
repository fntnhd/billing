package devops.demo.billing.service;


import devops.demo.billing.data.BillingDao;
import devops.demo.billing.entity.Account;
import devops.demo.billing.entity.AccountUsageCharge;
import devops.demo.billing.entity.Bill;
import devops.demo.billing.entity.BillingPeriod;
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
