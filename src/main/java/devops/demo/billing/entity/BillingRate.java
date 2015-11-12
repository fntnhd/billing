package devops.demo.billing.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Billing rate is a decimal with a precision to the nearest 1/100th
 *
 * Created by MrSteveAndrews on 11/11/15.
 */
public class BillingRate extends BigDecimal {

    public BillingRate(String rate) {
        super(rate);
        this.setScale(2, RoundingMode.HALF_UP);
    }

}
