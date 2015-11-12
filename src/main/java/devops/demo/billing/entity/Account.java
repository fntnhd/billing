package devops.demo.billing.entity;

/**
 * Encapsulates basic information about a customer account.
 *
 * Created by MrSteveAndrews on 11/8/15.
 */
public class Account {

    private String phoneNumber;
    private BillingPlan billingPlan;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BillingPlan getBillingPlan() {
        return billingPlan;
    }

    public void setBillingPlan(BillingPlan billingPlan) {
        this.billingPlan = billingPlan;
    }
}
