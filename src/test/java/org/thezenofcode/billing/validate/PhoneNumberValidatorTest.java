package org.thezenofcode.billing.validate;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Ensures that PhoneNumberValidator works correctly.
 */
public class PhoneNumberValidatorTest {

    @Test
    public void createPhoneNumbersWithValidFormats() {
        TestCase.assertTrue(PhoneNumberValidator.validate("206.555.1212"));
        TestCase.assertTrue(PhoneNumberValidator.validate("2065551212"));
        TestCase.assertTrue(PhoneNumberValidator.validate("(206)5551212"));
        TestCase.assertTrue(PhoneNumberValidator.validate("(206)555-1212"));
        TestCase.assertTrue(PhoneNumberValidator.validate("206-555-1212"));
        TestCase.assertTrue(PhoneNumberValidator.validate("(206)555.1212"));
    }

    @Test
    public void createPhoneNumberWithInvalidSymbols() {
        TestCase.assertFalse(PhoneNumberValidator.validate("206#555@1212"));
    }

    @Test
    public void createPhoneNumberWithInvalidNumberOfDigits() {
        TestCase.assertFalse(PhoneNumberValidator.validate("206555121"));
    }

    @Test
    public void createPhoneNumberWithInvalidLetters() {
        TestCase.assertFalse(PhoneNumberValidator.validate("206555A212"));
    }

}