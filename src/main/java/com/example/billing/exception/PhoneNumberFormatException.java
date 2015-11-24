package com.example.billing.exception;

import com.example.billing.entity.PhoneNumber;

/**
 * Created by MrSteveAndrews on 11/24/15.
 */
public class PhoneNumberFormatException extends Exception {

    public PhoneNumberFormatException(PhoneNumber phoneNumber) {
        super("Invalid phone number format:" + phoneNumber);
    }

}
