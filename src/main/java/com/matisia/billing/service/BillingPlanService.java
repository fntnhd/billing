package com.matisia.billing.service;

import com.matisia.billing.entity.BillingPlan;
import com.matisia.billing.exception.ValidationException;
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
     * Deletes all billing plans
     */
    void deleteAll();
}
