package com.example.billing.entity;

import com.example.billing.exception.ValidationException;
import com.example.billing.validate.PhoneNumberValidator;

/**
 * Encapsulates basic information about a customer account.
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

    /**
     * Ensures the account is valid.
     *
     * @throws ValidationException
     */
    public void validate() throws ValidationException {
        if(phoneNumber == null) {
            throw new ValidationException("Phone number is null");
        }

        if(billingPlan == null) {
            throw new ValidationException("Billing plan is null");
        }

        if(! PhoneNumberValidator.validate(phoneNumber)) {
            throw new ValidationException("Invalid phone number format");
        }

        normalizePhoneNumber();
    }

    /**
     * Normalize the getValue of the phone number to the standard format.
     */
    private void normalizePhoneNumber() {
        StringBuilder sb = new StringBuilder();
        char[] chars = phoneNumber.toCharArray();
        int pos = 0;
        for(int i=0; i<chars.length; i++) {
            if(Character.isDigit(chars[i])) {
                sb.append(chars[i]);
                pos++;
                if(pos==3 || pos==7) {
                    sb.append('-');
                    pos++;
                }
            }
        }

        this.phoneNumber = sb.toString();
    }

}
