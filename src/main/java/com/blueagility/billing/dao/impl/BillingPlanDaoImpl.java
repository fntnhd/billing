package com.blueagility.billing.dao.impl;

import com.blueagility.billing.dao.BillingPlanDao;
import com.blueagility.billing.entity.BillingPlan;
import com.blueagility.billing.exception.ValidationException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Responsible for persisting billing plans.
 */
@Repository
public class BillingPlanDaoImpl implements BillingPlanDao {

    private static Map<String, BillingPlan> BILLING_PLANS = null;

    static {
        BILLING_PLANS = new HashMap<String, BillingPlan>();
    }

    /**
     * Save a billing plan
     *
     * @param billingPlan
     * @return
     * @throws ValidationException
     */
    public BillingPlan save(BillingPlan billingPlan) throws ValidationException {
        BILLING_PLANS.put(billingPlan.getName(), billingPlan);
        return billingPlan;
    }

    /**
     * Find a billing plan by name
     * @param name
     * @return
     */
    public BillingPlan findBillingPlanByName(String name) {
        return BILLING_PLANS.get(name);
    }

    /**
     * Find all billing plans in the system
     * @return
     */
    public Collection<BillingPlan> findAll() {
        return BILLING_PLANS.values();
    }

    /**
     * Deletes a billing plan
     * @param billingPlan
     * @return The deleted billing plan
     * @throws ValidationException
     */
    public BillingPlan delete(BillingPlan billingPlan) throws ValidationException {
        BillingPlan existingBillingPlan = BILLING_PLANS.get(billingPlan.getName());
        BILLING_PLANS.remove(billingPlan.getName());
        return existingBillingPlan;
    }

    /**
     * Delete all billing plans from the system.
     */
    public void deleteAll() {
        BILLING_PLANS = new HashMap<String, BillingPlan>();
    }
}
