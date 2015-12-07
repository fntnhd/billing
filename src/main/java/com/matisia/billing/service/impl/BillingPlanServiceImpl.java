package com.matisia.billing.service.impl;

import com.matisia.billing.entity.BillingPlan;
import com.matisia.billing.exception.ValidationException;
import com.matisia.billing.service.BillingPlanService;
import org.springframework.stereotype.Service;

/**
 * Responsible for managing billing plans
 */
@Service
public class BillingPlanServiceImpl implements BillingPlanService {

    public BillingPlan findBillingPlanByName(String billingPlanName) {
        return null;
    }

    public BillingPlan createBillingPlan(BillingPlan billingPlan) throws ValidationException {
        return null;
    }

    public void deleteAll() {

    }
}
