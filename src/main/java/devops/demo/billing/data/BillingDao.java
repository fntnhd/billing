package devops.demo.billing.data;

import devops.demo.billing.entity.Account;
import devops.demo.billing.entity.AccountUsageCharge;
import devops.demo.billing.entity.BillingPeriod;
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
