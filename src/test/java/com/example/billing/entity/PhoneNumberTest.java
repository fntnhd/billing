package com.example.billing.entity;

import com.example.billing.exception.PhoneNumberFormatException;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by MrSteveAndrews on 11/24/15.
 */
public class PhoneNumberTest {

    @Test
    public void createPhoneNumbersWithValidFormats() {
        try {
            PhoneNumber phoneNumber = new PhoneNumber("206.555.1212");
            phoneNumber = new PhoneNumber("2065551212");
            phoneNumber = new PhoneNumber("(206)5551212");
            phoneNumber = new PhoneNumber("(206)555-1212");
            phoneNumber = new PhoneNumber("206-555-1212");
            phoneNumber = new PhoneNumber("(206)555.1212");
        }
        catch(PhoneNumberFormatException ex) {
            fail();
        }
    }

    @Test(expected=PhoneNumberFormatException.class)
    public void createPhoneNumberWithInvalidSymbols() throws PhoneNumberFormatException {
        PhoneNumber phoneNumber = new PhoneNumber("206#555@1212");
    }

    @Test(expected=PhoneNumberFormatException.class)
    public void createPhoneNumberWithInvalidNumberOfDigits() throws PhoneNumberFormatException {
        PhoneNumber phoneNumber = new PhoneNumber("206555121");
    }

    @Test(expected=PhoneNumberFormatException.class)
    public void createPhoneNumberWithInvalidLetters() throws PhoneNumberFormatException {
        PhoneNumber phoneNumber = new PhoneNumber("206555A212");
    }

    @Test
    public void normalizedValues() throws PhoneNumberFormatException {
        PhoneNumber phoneNumber = new PhoneNumber("2065551212");
        assertEquals("206-555-1212", phoneNumber.getValue());
    }

}