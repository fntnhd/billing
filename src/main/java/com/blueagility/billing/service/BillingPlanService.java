package com.blueagility.billing.service;

import com.blueagility.billing.entity.BillingPlan;
import com.blueagility.billing.exception.ValidationException;
import org.springframework.stereotype.Service;

/**
 * Responsible for managing billing plans.
 */
@Service
public interface BillingPlanService {

    /**
     * Finds a billing plan by name.
     * @param billingPlanName
     */
    BillingPlan findBillingPlanByName(String billingPlanName);


    /**
     * Creates a new
     * @param billingPlan
     * @return
     */
    BillingPlan createBillingPlan(BillingPlan billingPlan) throws ValidationException;

    /**
     * Deletes a billing plan
     * @param billingPlan
     * @return The billing plan that was deleted
     * @throws ValidationException
     */
    BillingPlan deleteBillingPlan(BillingPlan billingPlan) throws ValidationException;


    /**
     * Deletes all billing plans
     */
    void deleteAll();
}
