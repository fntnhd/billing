package com.matisia.billing.dao;

import com.matisia.billing.entity.BillingPlan;
import com.matisia.billing.exception.ValidationException;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Responsible for persisting billing plans.
 */
@Repository
public interface BillingPlanDao {

    /**
     * Save a billing plan
     *
     * @param billingPlan
     * @return
     * @throws ValidationException
     */
    BillingPlan save(BillingPlan billingPlan) throws ValidationException;

    /**
     * Find a billing plan by name
     * @param name
     * @return
     */
    BillingPlan findBillingPlanByName(String name);

    /**
     * Find all billing plans in the system
     * @return
     */
    Collection<BillingPlan> findAll();

    /**
     * Deletes a billing plan
     * @param billingPlan
     * @return The billing plan that was deleted
     * @throws ValidationException
     */
    public BillingPlan delete(BillingPlan billingPlan) throws ValidationException;

    /**
     * Delete all billing plans from the system.
     */
    void deleteAll();

}
