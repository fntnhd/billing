package com.blueagility.billing.service.impl;

import com.blueagility.billing.dao.BillingPlanDao;
import com.blueagility.billing.entity.BillingPlan;
import com.blueagility.billing.exception.ValidationException;
import com.blueagility.billing.service.BillingPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Responsible for managing billing plans
 */
@Service
public class BillingPlanServiceImpl implements BillingPlanService {

    @Resource
    private BillingPlanDao billingPlanDao;

    /**
     * Finds a billing plan by name.
     * @param billingPlanName
     */
    public BillingPlan findBillingPlanByName(String billingPlanName) {
        return billingPlanDao.findBillingPlanByName(billingPlanName);
    }

    /**
     * Creates a new
     * @param billingPlan
     * @return The new billing plan
     */
    public BillingPlan createBillingPlan(BillingPlan billingPlan) throws ValidationException {
        billingPlan.validate();

        if(billingPlanDao.findBillingPlanByName(billingPlan.getName()) != null) {
            throw new ValidationException("Billing plan already exists with name " + billingPlan.getName());
        }

        return billingPlanDao.save(billingPlan);
    }

    /**
     * Deletes a billing plan
     * @param billingPlan
     * @return The billing plan that was deleted
     * @throws ValidationException
     */
    public BillingPlan deleteBillingPlan(BillingPlan billingPlan) throws ValidationException {
        return billingPlanDao.delete(billingPlan);
    }

    /**
     * Delete all billing plans in the system
     */
    public void deleteAll() {
        billingPlanDao.deleteAll();
    }
}
