package org.thezenofcode.billing.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by MrSteveAndrews on 11/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class BillCalculatorTest {

    @Autowired
    private BillCalculator billCalculator;


    @Test
    public void validateBillCalculatorNotNull() {
        assertNotNull(billCalculator);
    }


}
