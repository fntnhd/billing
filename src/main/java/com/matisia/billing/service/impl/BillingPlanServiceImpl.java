package com.matisia.billing.service.impl;

import com.matisia.billing.dao.BillingPlanDao;
import com.matisia.billing.entity.BillingPlan;
import com.matisia.billing.exception.ValidationException;
import com.matisia.billing.service.BillingPlanService;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
     * @return
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
        throw new NotImplementedException();
    }

    public void deleteAll() {
        billingPlanDao.deleteAll();
    }
}
