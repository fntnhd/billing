package com.example.billing.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ensures that a phone number conforms to the standard format.
 */
public class PhoneNumberValidator {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$");

    /**
     * Answers whether a phone number conforms to a known format.
     *
     * @param phoneNumber
     * @return
     */
    public static boolean validate(String phoneNumber) {
        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(phoneNumber);
        return matcher.matches();
    }

}
