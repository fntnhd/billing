package com.matisia.billing.service.impl;

import com.matisia.billing.dao.BillingPlanDao;
import com.matisia.billing.entity.BillingPlan;
import com.matisia.billing.exception.ValidationException;
import com.matisia.billing.service.BillingPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Responsible for managing billing plans
 */
@Service
public class BillingPlanServiceImpl implements BillingPlanService {

    @Resource
    private BillingPlanDao billingPlanDao;

    public BillingPlan findBillingPlanByName(String billingPlanName) {
        return billingPlanDao.findBillingPlanByName(billingPlanName);
    }

    public BillingPlan createBillingPlan(BillingPlan billingPlan) throws ValidationException {
        billingPlan.validate();

        if(billingPlanDao.findBillingPlanByName(billingPlan.getName()) != null) {
            throw new ValidationException("Billing plan already exists with name " + billingPlan.getName());
        }

        return billingPlanDao.save(billingPlan);
    }

    public void deleteAll() {
        billingPlanDao.deleteAll();
    }
}
